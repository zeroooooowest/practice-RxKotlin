package me.zw.`do`

import io.reactivex.Observable
import me.zw.utils.LogType
import me.zw.utils.Logger


fun main() {

    // 생산자가 완료를 통지하는 시점에, 지정된 작업을 처리할 수 있다.
    // onComplete 이벤트가 발생하기 직전에 실행된다.

    Observable.range(1, 5)
        .doOnComplete { Logger.log(LogType.DO_ON_COMPLETE, "# 생산자: 데이터 통지 완료") }
        .subscribe(
            { Logger.log(LogType.ON_NEXT, it) },
            { Logger.log(LogType.ON_ERROR, it) },
            { Logger.log(LogType.ON_COMPLETE) }
        )
}