package me.zw.operator

import io.reactivex.Observable
import me.zw.utils.LogType
import me.zw.utils.Logger
import me.zw.utils.TimeUtil
import java.util.concurrent.TimeUnit


// 에러 처리 연산자: onErrorReturn
fun main() {

    // 에러가 발생했을 때 에러를 의미하는 데이터로 대체할 수 있다.
    // onErrorReturn 이 호출되면 onError 이벤트는 발생하지 않는다.

    Observable.just(5)
        .flatMap { num ->
            Observable.interval(200L, TimeUnit.MILLISECONDS)
                .take(5)
                .map { num / it }
                .onErrorReturn { ex ->
                    if (ex is ArithmeticException) {
                        Logger.log(LogType.PRINT, "계산 처리 에러 발생: ${ex.message}")
                    }
                    return@onErrorReturn -1L
                }
        }
        .subscribe(
            { data ->
                if (data < 0)
                    Logger.log(LogType.PRINT, "# 예외를 알리는 데이터: $data")
                else
                    Logger.log(LogType.ON_NEXT, data)
            },
            { error -> Logger.log(LogType.ON_ERROR, error) },
            { Logger.log(LogType.ON_COMPLETE) }
        )

    TimeUtil.sleep(1000L)
}