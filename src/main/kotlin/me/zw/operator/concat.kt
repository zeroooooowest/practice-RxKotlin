package me.zw.operator

import io.reactivex.Observable
import me.zw.utils.LogType
import me.zw.utils.Logger
import me.zw.utils.TimeUtil
import java.util.concurrent.TimeUnit


// 데이터 결합 연산자: concat
fun main() {

    // 다수의 Observable 에서 통지된 데이터를 받아 하나의 Observable 로 통지한다.
    // 각 Observable 의 통지 시점과는 상관없이 concat() 함수의 파라미터로 먼저 입력된 Observable 의 데이터부터 통지.
    val observable1 = Observable.interval(500L, TimeUnit.MILLISECONDS)
        .take(4)

    val observable2 = Observable.interval(300L, TimeUnit.MILLISECONDS)
        .take(5)
        .map { it + 1000 }

    Observable.concat(observable1, observable2)
        .subscribe { Logger.log(LogType.ON_NEXT, it) }

    TimeUtil.sleep(3500L)
}