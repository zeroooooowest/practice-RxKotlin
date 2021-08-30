package me.zw.operator

import io.reactivex.Observable
import me.zw.utils.LogType
import me.zw.utils.Logger
import me.zw.utils.TimeUtil
import java.util.concurrent.TimeUnit


// 데이터 결합 연산자: combineLatest
fun main() {

    // 각각의 Observable 에서 데이터를 통지할 때마다
    // 모든 Observable 에서 마지막으로 통지한 각 데이터를 함수형 인터페이스에 전달하여 새로운 데이터를 생성하여 통지.

    val observable1 = Observable.interval(500L, TimeUnit.MILLISECONDS)
//        .doOnNext { Logger.log("# observable 1: $it") }
        .take(4)

    val observable2 = Observable.interval(700L, TimeUnit.MILLISECONDS)
//        .doOnNext { Logger.log("# observable 2: $it") }
        .take(4)

    Observable.combineLatest(observable1, observable2) { data1, data2 -> "data1: $data1 \tdata2: $data2" }
        .subscribe { Logger.log(LogType.ON_NEXT, it) }

    TimeUtil.sleep(3000L)
}