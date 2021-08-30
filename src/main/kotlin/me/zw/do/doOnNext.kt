package me.zw.`do`

import io.reactivex.Observable
import me.zw.utils.LogType
import me.zw.utils.Logger


fun main() {

    // 생산자가 데이터를 통지하는 시점에, 지정된 작업을 처리할 수 있다.
    // onNext() 이벤트가 발생하기 직전에 실행된다.

    Observable.just(1, 3, 5, 7, 9, 10, 11, 12, 13)
        .doOnNext { Logger.log(LogType.DO_ON_NEXT, "# 원본 통지 데이터: $it") }
        .filter { it < 10 }
        .doOnNext { Logger.log(LogType.DO_ON_NEXT, "# filter 적용 후: $it") }
        .map { "#### $it ####" }
        .doOnNext { Logger.log(LogType.DO_ON_NEXT, "# map 적용 후: $it") }
        .subscribe { Logger.log(LogType.ON_NEXT, "# 최종 데이터: $it") }
}