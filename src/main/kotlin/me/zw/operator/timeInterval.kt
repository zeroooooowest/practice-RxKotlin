package me.zw.operator

import io.reactivex.Observable
import me.zw.utils.LogType
import me.zw.utils.Logger
import me.zw.utils.TimeUtil
import kotlin.random.Random
import kotlin.random.nextLong


// 유틸리티 연산자: timeInterval
fun main() {

    // 각각의 데이터가 통지되는데 걸린 시간을 함께 통지한다.
    Observable.just(1, 3, 5, 7, 9)
        .delay { item ->
            TimeUtil.sleep(Random.nextLong(LongRange(100, 1000)))
            return@delay Observable.just(item)
        }
        .timeInterval()
        .subscribe { Logger.log(LogType.ON_NEXT, "# 통지하는데 걸린 시간: ${it.time()}\t# 통지된 데이터: ${it.value()}") }

}