package me.zw.`do`

import io.reactivex.Observable
import me.zw.utils.LogType
import me.zw.utils.Logger


fun main() {

    // 생산자가 에러를 통지하는 시점에, 지정된 작업을 처리할 수 있다.
    // onError 이벤트가 발생하기 직전에 실행된다.

    Observable.just(3, 6, 9, 12, 15, 20)
        .zipWith(Observable.just(1, 2, 3, 4, 0, 5)) { a, b -> a / b }
        .doOnError { Logger.log(LogType.DO_ON_ERROR, "# 생산자: 에러 발생 - ${it.message}") }
        .subscribe(
            { Logger.log(LogType.ON_NEXT, it) },
            { Logger.log(LogType.ON_ERROR, it) }
        )
}