package me.zw.operator

import io.reactivex.Observable
import me.zw.utils.LogType
import me.zw.utils.Logger
import me.zw.utils.TimeUtil
import java.util.concurrent.TimeUnit


// 에러 처리 연산자: onErrorResumeNext
fun main() {

    // 에러가 발생했을 때 에러를 의미하는 Observable 로 대체하거나 더불어 에러 처리를 위한 추가 작업을 할 수 있다.

    Observable.just(5L)
        .flatMap { num ->
            Observable.interval(200L, TimeUnit.MILLISECONDS)
                .take(5)
                .map { num / it }
                .onErrorResumeNext { ex: Throwable ->
                    Logger.log(LogType.PRINT, "# 운영자에게 이메일 발송: ${ex.message}")

                    return@onErrorResumeNext Observable.interval(200L, TimeUnit.MILLISECONDS)
                        .take(5)
                        .skip(1)
                        .map { num / it }
                }
        }
        .subscribe { Logger.log(LogType.ON_NEXT, it) }

    TimeUtil.sleep(2000L)
}