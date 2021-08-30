package me.zw.operator

import io.reactivex.Observable
import me.zw.utils.LogType
import me.zw.utils.Logger
import me.zw.utils.TimeUtil
import java.util.concurrent.TimeUnit


// 데이터 결합 연산자: zip
fun main() {

    // 다수의 Observable 에서 통지된 데이터가 모두 모이면 각 Observable 에서 동일한 index 의 데이터로 새로운 데이터를 생성 후 통지.
    // 통지하는 데이터 개수가 가장 적은 Observable 의 통지 시점에 완료 시점을 맞춘다.

    val observable1 = Observable.interval(200L, TimeUnit.MILLISECONDS)
        .take(4)

    val observable2 = Observable.interval(400L, TimeUnit.MILLISECONDS)
        .take(6)

    Observable.zip(observable1, observable2) { data1, data2 -> data1 + data2 }
        .subscribe { Logger.log(LogType.ON_NEXT, it) }

    TimeUtil.sleep(3000L)
}