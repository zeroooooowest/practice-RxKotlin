package me.zw.operator

import io.reactivex.Observable
import me.zw.utils.LogType
import me.zw.utils.Logger
import me.zw.utils.TimeUtil
import java.util.concurrent.TimeUnit

const val RETRY_MAX = 5

// 에러 처리 연산자: retry
fun main() {

    // 데이터 통지 중 에러가 발생했을 때, 처음부터 데이터 통지를 재시도한다.
    // 즉, onError() 이벤트가 발생하면 subscribe() 를 다시 호출하여 재구독한다.

    Observable.just(5)
        .flatMap { num ->
            Observable.interval(200L, TimeUnit.MILLISECONDS)
                .map {
                    try {
                        return@map num / it
                    } catch (ex: ArithmeticException) {
                        Logger.log(LogType.PRINT, "error: ${ex.message}")
                        throw ex
                    }
                }
//                .retry(5)
                .retry { retryCount, ex ->
                    Logger.log(LogType.PRINT, "# 재시도 횟수: $retryCount")
                    TimeUtil.sleep(1000L)   // 에러 발생 시 즉시 재시도 하지 않고, 지연 시간을 주고 재시도.

                    return@retry retryCount < RETRY_MAX
                }
                .onErrorReturn { -1L }
        }
        .subscribe(
            { data -> Logger.log(LogType.ON_NEXT, data) },
            { error -> Logger.log(LogType.ON_ERROR, error) },
            { Logger.log(LogType.ON_COMPLETE) }
        )

    TimeUtil.sleep(5000L)
}