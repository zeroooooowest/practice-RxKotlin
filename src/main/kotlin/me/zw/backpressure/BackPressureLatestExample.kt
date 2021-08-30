package me.zw.backpressure

import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers
import me.zw.utils.LogType
import me.zw.utils.Logger
import me.zw.utils.TimeUtil
import java.util.concurrent.TimeUnit

fun main() {

    // 버퍼가 가득차면 버퍼 밖에서 대기중인 통지된 데이터 중에서 가장 최근에 통지된 데이터부터 버퍼에 채운다.

    Flowable.interval(300L, TimeUnit.MILLISECONDS)
        .doOnNext { data -> Logger.log("#interval doOnNext()", data) }
        .onBackpressureLatest()
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