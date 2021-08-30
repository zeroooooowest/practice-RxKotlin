package me.zw.backpressure

import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers
import me.zw.utils.LogType
import me.zw.utils.Logger
import me.zw.utils.TimeUtil
import java.util.concurrent.TimeUnit

fun main() {

    // 버퍼가 가득차면 통지 대기중인 데이터들은 버퍼가 비워질 때까지 계속 DROP 되는 전략
    Flowable.interval(300L, TimeUnit.MILLISECONDS)
        .doOnNext { data -> Logger.log("interval doOnNext()", data) }
        .onBackpressureDrop { dropData -> Logger.log(LogType.PRINT, "$dropData Drop!") }
        .observeOn(Schedulers.computation(), false, 1)
        .subscribe(
            { data ->
                TimeUtil.sleep(1000L)
                Logger.log(LogType.ON_NEXT, data)
            },
            { error -> Logger.log(LogType.ON_ERROR, error) }
        )

    TimeUtil.sleep(5500L)
}