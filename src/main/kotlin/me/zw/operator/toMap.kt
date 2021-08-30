package me.zw.operator

import io.reactivex.Observable
import me.zw.utils.LogType
import me.zw.utils.Logger


// 데이터 변환 연산자: toMap
fun main() {

    // 원본 Observable 에서 완료 통지를 받는 즉시 Map 하나를 담은 Single 을 통지한다.
    // 이미 사용중인 key 를 또 생성하면 기존에 있던 key 와 value 를 덮어쓴다.

    val single = Observable.just("a-Alpha", "b-Bravo", "c-Charlie", "e-Echo")
        .toMap { it.split("-")[0] } // 반환값은 Map 의  key 가 된다.

    single.subscribe { map -> Logger.log(LogType.ON_NEXT, map) }

    println()

    val single2 = Observable.just("a-Alpha", "b-Bravo", "c-Charlie", "e-Echo")
        .toMap(
            { it.split("-")[0] },
            { it.split("-")[1] }
        )
    single2.subscribe { map -> Logger.log(LogType.ON_NEXT, map) }
}