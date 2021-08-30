package me.zw.operator

import io.reactivex.Observable
import me.zw.utils.LogType
import me.zw.utils.Logger


// 생성 연산자: fromIterable
fun main() {
    val countries = listOf("Korea", "Canada", "USA", "Italy")

    // Iterable 인터페이스를 구현한 파라미터를 받아 담긴 데이터를 순서대로 통지한다.
    Observable.fromIterable(countries)
        .subscribe { Logger.log(LogType.ON_NEXT, it) }

}