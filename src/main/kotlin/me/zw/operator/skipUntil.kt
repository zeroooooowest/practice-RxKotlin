package me.zw.operator

import io.reactivex.Observable
import me.zw.utils.LogType
import me.zw.utils.Logger
import java.util.concurrent.TimeUnit


// 데이터 필터링 연산자: skipUntil
fun main() {

    Observable.interval(1000L, TimeUnit.MILLISECONDS)
        .skipUntil(Observable.timer(3000L, TimeUnit.MILLISECONDS))
        .subscribe { Logger.log(LogType.ON_NEXT, it) }

    Thread.sleep(11000L)
}