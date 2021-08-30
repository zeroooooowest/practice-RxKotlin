package me.zw.operator

import io.reactivex.Observable
import me.zw.utils.LogType
import me.zw.utils.Logger
import me.zw.utils.TimeUtil
import java.util.concurrent.TimeUnit


// 유틸리티 연산자: timeout
fun main() {

    // 각각의 데이터 통지 시, 지정된 시간안에 통지가 되지 않으면 에러(TimeoutException)를 통지
    Observable.range(1, 5)
        .map { num ->
            TimeUtil.sleep(if (num == 4) 1500L else 1000L)
            num
        }
        .timeout(1200L, TimeUnit.MILLISECONDS)
        .subscribe(
            { Logger.log(LogType.ON_NEXT, it) },
            { Logger.log(LogType.ON_ERROR, it) }
        )

    TimeUtil.sleep(4000L)
}