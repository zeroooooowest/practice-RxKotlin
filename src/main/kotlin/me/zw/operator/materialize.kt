package me.zw.operator

import io.reactivex.Observable
import me.zw.utils.LogType
import me.zw.utils.Logger


// 유틸리티 연산자: materialize
fun main() {

    // 통지된 데이터의 통지 타입 자체를 Notification 객체에 담아 통지한다.
    Observable.just(1, 2, 3, 4, 5, 6)
        .materialize()
        .subscribe { notification ->
            val type =
                if (notification.isOnNext) "onNext()"
                else if (notification.isOnError) "onError()"
                else "onComplete()"

            Logger.log(LogType.PRINT, "notification 타입: $type")
            notification.value?.let { Logger.log(LogType.ON_NEXT, it) }
        }
}