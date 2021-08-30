package me.zw.operator

import io.reactivex.Observable
import me.zw.utils.LogType
import me.zw.utils.Logger
import me.zw.utils.TimeUtil
import java.util.concurrent.TimeUnit

// 데이터 필터링 연산자: takeWhile
fun main() {

    Observable.interval(1000L, TimeUnit.MILLISECONDS)
        .takeWhile { it != 10L }
        .subscribe { Logger.log(LogType.ON_NEXT, it) }


    TimeUtil.sleep(12000L)
}