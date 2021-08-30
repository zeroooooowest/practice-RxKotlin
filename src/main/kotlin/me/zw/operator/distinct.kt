package me.zw.operator

import io.reactivex.Observable
import me.zw.common.CarMaker
import me.zw.common.SampleData
import me.zw.utils.LogType
import me.zw.utils.Logger
import me.zw.utils.TimeUtil

// 데이터 필터링 연산자: distinct
fun main() {

    Observable.fromIterable(SampleData.carMakersDuplicated)
        .distinct()
        .filter { it == CarMaker.SSANGYOUNG }
        .subscribe { Logger.log(LogType.ON_NEXT, it) }


    TimeUtil.sleep(1000L)

    Observable.fromIterable(SampleData.carList)
        .distinct { it.carMaker }
        .subscribe { Logger.log(LogType.ON_NEXT, it.carName) }
}