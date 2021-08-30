package me.zw.operator

import io.reactivex.Observable
import me.zw.common.SampleData
import me.zw.utils.LogType
import me.zw.utils.Logger
import me.zw.utils.TimeUtil
import java.util.concurrent.TimeUnit

// 데이터 필터링 연산자: takeUntil
fun main() {

    // 1. 파라미터로 입력받은 '조건' 이 true 가 될 때까지 계속 데이터를 통지
    Observable.fromIterable(SampleData.carList)
        .takeUntil { it.carName == "트랙스" }
        .subscribe(System.out::println)

    // 2. 파라미터로 입력받은 'Observable' 이 최초로 데이터를 통지할 때까지 계속 데이터를 통지
    Observable.interval(1000L, TimeUnit.MILLISECONDS)
        .takeUntil(Observable.timer(5500L, TimeUnit.MILLISECONDS))
        .subscribe { Logger.log(LogType.ON_NEXT, it) }

    TimeUtil.sleep(5500L)

}