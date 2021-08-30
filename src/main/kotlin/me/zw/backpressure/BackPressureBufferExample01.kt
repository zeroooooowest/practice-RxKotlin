package me.zw.backpressure

import io.reactivex.BackpressureOverflowStrategy
import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers
import me.zw.utils.LogType
import me.zw.utils.Logger
import me.zw.utils.TimeUtil
import java.util.concurrent.TimeUnit


fun main() {
    println("# start: ${TimeUtil.currentTimeFormatted}")

    // DROP_LATEST 배압 전략
    Flowable.interval(300L, TimeUnit.MILLISECONDS)
        .doOnNext { data -> Logger.log("#interval doOnNext()", data) }
        .onBackpressureBuffer(
            2,
            { Logger.log("overflow!") },
            BackpressureOverflowStrategy.DROP_LATEST
        )
        .doOnNext { data -> Logger.log("#onBackpressureBuffer doOnNext()", data) }
        .observeOn(Schedulers.computation(), false, 1)
        .subscribe(
            { data ->
                TimeUtil.sleep(1000L)
                Logger.log(LogType.ON_NEXT, data)
            },
            { error -> Logger.log(LogType.DO_ON_ERROR, error) }
        )

    TimeUtil.sleep(2800L)
}