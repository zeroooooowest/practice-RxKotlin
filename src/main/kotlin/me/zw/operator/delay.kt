package me.zw.operator

import io.reactivex.Observable
import me.zw.utils.LogType
import me.zw.utils.Logger
import me.zw.utils.TimeUtil
import java.util.concurrent.TimeUnit


// 유틸리티 연산자: delay
fun main() {

    // 1. 생산자는 데이터를 통지하지만 설정한 시간만큼 소비자쪽으로의 데이터 전달을 지연시킨다.
    Observable.just(1, 3, 4, 6)
        .doOnNext { Logger.log(LogType.DO_ON_NEXT, it) }
        .delay(2000L, TimeUnit.MILLISECONDS)
        .subscribe { Logger.log(LogType.ON_NEXT, it) }

    TimeUtil.sleep(2500L)


    // 2. 파라미터로 입력받은 Observable 이 데이터를 통지할 때까지 각각의 원본 데이터의 통지를 지연시킨다.
    Observable.just(1, 3, 5, 7)
        .delay { item ->
            TimeUtil.sleep(1000L)
            return@delay Observable.just(item + 10)
        }
        .subscribe { Logger.log(LogType.ON_NEXT, it) }
}