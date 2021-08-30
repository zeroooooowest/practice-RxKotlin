package me.zw.operator

import io.reactivex.Observable
import me.zw.common.CarMaker
import me.zw.common.SampleData
import me.zw.utils.LogType
import me.zw.utils.Logger


// 조건 연산자: all
fun main() {

    // 통지되는 모든 데이터가 설정한 조건에 맞는지 판단하여 true/false 를 Single 로 반환
    // 통지된 데이터가 조건에 맞지 않는다면 이후에는 구독 해지되어 통지되지 않는다.
    Observable.fromIterable(SampleData.carList)
        .doOnNext { Logger.log(LogType.DO_ON_NEXT, "Car Maker: ${it.carMaker}\tCar Name: ${it.carName}") }
        .map { it.carMaker }
        .all { it == CarMaker.CHEVROLET }
        .subscribe { data -> Logger.log(LogType.ON_NEXT, data) }
}