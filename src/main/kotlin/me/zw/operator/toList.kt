package me.zw.operator

import io.reactivex.Observable
import me.zw.common.SampleData
import me.zw.utils.LogType
import me.zw.utils.Logger


// 데이터 변환 연산자: toList
fun main() {

    // 원본 Observable 에서 완료 통지를 받는 즉시 리스트를 통지한다.
    // 통지되는 데이터는 원본 데이터를 담은 리스트 하나이므로 Single 로 반환.

    val single = Observable.just(1, 3, 5, 7, 9)
        .toList()

    single.subscribe { data -> Logger.log(LogType.ON_NEXT, data) }

}