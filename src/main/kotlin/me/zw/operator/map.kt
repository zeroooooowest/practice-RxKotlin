package me.zw.operator

import io.reactivex.Observable
import me.zw.utils.LogType
import me.zw.utils.Logger

// 데이터 변환 연산자: map
fun main() {

    // 원본 Observable 에서 통지하는 데이터를 원하는 값으로 변환 후 통지

    Observable.fromIterable(listOf(1, 3, 5, 7))
        .map { "1을 더한 결과: ${it + 1}" }
        .subscribe { Logger.log(LogType.ON_NEXT, it) }

    Observable.just("korea", "america", "canada", "paris", "japan", "china")
        .filter { it.length == 5 }
        .map { "${it.uppercase()[0]}${it.substring(1)}" }
        .subscribe { Logger.log(LogType.ON_NEXT, it) }

}