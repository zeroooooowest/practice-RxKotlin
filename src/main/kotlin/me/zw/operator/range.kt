package me.zw.operator

import io.reactivex.Observable
import me.zw.utils.LogType
import me.zw.utils.Logger

// 생성 연산자: range
fun main() {

    // 지정한 값(n) 부터 m 개의 숫자(Integer)를 통지
    // for, while 등의 반복문을 대체할 수 있다.
    val range = Observable.range(0, 5)
    range.subscribe { Logger.log(LogType.ON_NEXT, it) }
}