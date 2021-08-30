package me.zw.operator

import io.reactivex.Observable
import me.zw.utils.LogType
import me.zw.utils.Logger
import me.zw.utils.TimeUtil
import java.util.concurrent.TimeUnit


// 유틸리티 연산자: delaySubscription
fun main() {

    // 생산자가 데이터의 생성 및 통지 자체를 지연시킨다.
    // 즉, 소비자가 구독을 해도 구독 시점 자체가 지연된다.
    Observable.just(1, 3, 4, 6)
        .doOnNext { Logger.log(LogType.DO_ON_NEXT, it) }
//        .delay(2000L, TimeUnit.MILLISECONDS)  // 비교해보자
        .delaySubscription(2000L, TimeUnit.MILLISECONDS)
        .subscribe { Logger.log(LogType.ON_NEXT, it) }

    TimeUtil.sleep(2500L)

}