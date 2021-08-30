package me.zw.operator

import io.reactivex.Observable
import me.zw.utils.LogType
import me.zw.utils.Logger
import me.zw.utils.TimeUtil
import java.util.concurrent.TimeUnit


// 데이터 필터링 연산자: take
fun main() {

    Observable.just("a", "b", "c", "d")
        .take(2)
        .subscribe { Logger.log(LogType.ON_NEXT, it) }

    println()

    Observable.interval(1000L, TimeUnit.MILLISECONDS)
        .take(3500L, TimeUnit.MILLISECONDS)
        .subscribe { Logger.log(LogType.ON_NEXT, it) }

    TimeUtil.sleep(3500L)
}