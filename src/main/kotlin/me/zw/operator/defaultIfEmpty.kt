package me.zw.operator

import io.reactivex.Observable
import me.zw.utils.LogType
import me.zw.utils.Logger


// 조건 연산자: defaultIfEmpty
fun main() {

    // 통지할 데이터가 없을 경우 파라미터로 입력된 값을 통지
    Observable.just(1, 2, 3, 4, 5)
        .filter { it > 10 }
        .defaultIfEmpty(10)
        .subscribe { Logger.log(LogType.ON_NEXT, it) }
}