package me.zw.operator

import io.reactivex.Observable
import me.zw.utils.LogType
import me.zw.utils.Logger


// 데이터 필터링 연산자: skipLast
fun main() {

    Observable.range(1, 15)
        .skipLast(3)
        .subscribe { Logger.log(LogType.ON_NEXT, it) }
}