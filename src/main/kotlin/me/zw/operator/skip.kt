package me.zw.operator

import io.reactivex.Observable
import me.zw.utils.LogType
import me.zw.utils.Logger
import me.zw.utils.TimeUtil
import java.util.concurrent.TimeUnit

// 데이터 필터링 연산자: skip
fun main() {

    Observable.range(1, 15)
        .skip(3)
        .subscribe { Logger.log(LogType.ON_NEXT, it) }

    println()

    Observable.interval(300L, TimeUnit.MILLISECONDS)
        .skip(1000L, TimeUnit.MILLISECONDS)
        .subscribe { Logger.log(LogType.ON_NEXT, it) }

    TimeUtil.sleep(3000L)

}