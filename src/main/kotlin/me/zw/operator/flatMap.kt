package me.zw.operator

import io.reactivex.Observable
import me.zw.utils.LogType
import me.zw.utils.Logger


// 데이터 변환 연산자: flatMap
fun main() {

    // map 은 변환된 데이터를 반환하지만, flatMap 은 변환된 여러개의 데이터를 담고 있는 Observable 을 반환한다.

    Observable.just("Hello")
        .flatMap { hello ->
            Observable.just("자바", "코틀린", "스위프트")
                .map { "$hello, $it" }
        }
        .subscribe { Logger.log(LogType.ON_NEXT, it) }

    println()

    Observable.range(2, 1)
        .flatMap { num ->
            Observable.range(1, 9)
                .map { "$num * $it = ${num * it}" }
        }
        .subscribe { Logger.log(LogType.ON_NEXT, it) }

    println()

    Observable.range(2, 1)
        .flatMap({
            Observable.range(
                1,
                9
            )
        }) { sourceData, transformData ->
            "$sourceData * $transformData = ${sourceData * transformData}"
        }
        .subscribe { Logger.log(LogType.ON_NEXT, it) }
}