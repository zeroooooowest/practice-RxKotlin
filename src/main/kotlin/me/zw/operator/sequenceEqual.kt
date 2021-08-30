package me.zw.operator

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import me.zw.common.SampleData
import me.zw.utils.LogType
import me.zw.utils.Logger
import me.zw.utils.TimeUtil


// 조건 연산자: sequenceEqual
fun main() {

    // 통지 시점과 무관하게 두 Observable 이 동일한 순서로 동일한 갯수의 같은 데이터를 통지하는지 판단.
    val observable1 = Observable.fromIterable(SampleData.carMakers.toList())
        .subscribeOn(Schedulers.computation())
        .delay { carMaker ->
            TimeUtil.sleep(500L)
            Observable.just(carMaker)
        }
        .doOnNext { Logger.log(LogType.DO_ON_NEXT, "# observable1 : $it") }

    val observable2 = Observable.fromIterable(SampleData.carMakersDuplicated.toList())
        .delay { carMaker ->
            TimeUtil.sleep(1000L)
            Observable.just(carMaker)
        }
        .doOnNext { Logger.log(LogType.DO_ON_NEXT, "# observable2: $it") }

    Observable.sequenceEqual(observable1, observable2)
        .subscribe { data -> Logger.log(LogType.ON_NEXT, data) }

}