package me.zw.`do`

import io.reactivex.Notification
import io.reactivex.Observable
import me.zw.utils.LogType
import me.zw.utils.Logger


fun main() {

    // doOnNext, doOnComplete, doOnError 를 한번에 처리할 수 있다.
    // Notification 객체를 함수형 인터페이스의 파라미터로 전달 받아 처리.

    Observable.range(1, 5)
        .doOnEach { notification: Notification<Int> ->
            when {
                notification.isOnNext -> Logger.log(LogType.DO_ON_NEXT, "# 생산자: 데이터 통지 - ${notification.value}")
                notification.isOnError -> Logger.log(LogType.DO_ON_ERROR, "# 생산자: 에러 발생 - ${notification.error}")
                else -> Logger.log(LogType.DO_ON_COMPLETE, "# 생산자: 데이터 통지 완료")
            }
        }
        .subscribe(
            { Logger.log(LogType.ON_NEXT, it) },
            { Logger.log(LogType.ON_ERROR, it) },
            { Logger.log(LogType.ON_COMPLETE) }
        )
}