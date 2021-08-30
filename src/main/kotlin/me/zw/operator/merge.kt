package me.zw.operator

import io.reactivex.Observable
import me.zw.utils.LogType
import me.zw.utils.Logger
import me.zw.utils.TimeUtil
import java.util.concurrent.TimeUnit


// 데이터 결합 연산자: merge
fun main() {

    // 여러 개의 Observable 에서 통지된 데이터를 받아서 하나의 Observable 로 통지한다.
    // 통지 시점이 빠른 데이터부터 통지된다. 시점이 같을 경우 merge() 함수의 파라미터로 먼저 지정된 Observable 의 데이터부터 통지.

    val observable1 = Observable.interval(200L, TimeUnit.MILLISECONDS)
        .take(5)

    val observable2 = Observable.interval(400L, TimeUnit.MILLISECONDS)
        .take(5)
        .map { it + 1000 }

    Observable.merge(observable1, observable2)
        .subscribe { Logger.log(LogType.ON_NEXT, it) }

    TimeUtil.sleep(4000)
}