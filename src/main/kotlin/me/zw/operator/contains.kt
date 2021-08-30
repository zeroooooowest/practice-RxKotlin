package me.zw.operator

import io.reactivex.Observable
import me.zw.common.CarMaker
import me.zw.common.SampleData
import me.zw.utils.LogType
import me.zw.utils.Logger


// 조건 연산자: contains
fun main() {

    // 파라미터의 데이터가 Observable 에 포함되어 있는지 판단하여 true/false 값을 Single 반환.
    // 결과 통지 시점은 Observable 에 포함된 데이터를 통지하거나 완료를 통지할 때이다.
    Observable.fromIterable(SampleData.carMakersDuplicated.toList())
        .doOnNext { Logger.log(LogType.DO_ON_NEXT, it) }
        .contains(CarMaker.SAMSUNG)
        .subscribe { data -> Logger.log(LogType.ON_NEXT, data) }
}