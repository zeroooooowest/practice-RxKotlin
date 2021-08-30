package me.zw.operator

import io.reactivex.Observable
import me.zw.common.CarMaker
import me.zw.common.SampleData
import me.zw.utils.LogType
import me.zw.utils.Logger

// 데이터 필터링 연산자: filter
fun main() {

    Observable.fromIterable(SampleData.carList)
            .filter { it.carMaker == CarMaker.CHEVROLET }
            .filter { it.carPrice > 30000000 }
            .subscribe { Logger.log(LogType.ON_NEXT, "${it.carMaker} : ${it.carName}") }

}