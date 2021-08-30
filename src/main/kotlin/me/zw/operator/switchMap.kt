package me.zw.operator

import io.reactivex.Observable
import me.zw.utils.LogType
import me.zw.utils.Logger
import me.zw.utils.TimeUtil
import java.util.concurrent.TimeUnit


// 데이터 변환 연산자: switchMap
fun main() {

    // concatMap 과 마찬가지로 받은 데이터를 변환하여 새로운 Observable 로 반환
    // concatMap 과 다른 점은 switchMap 은 새로운 데이터가 통지되면 현재 처리 중인 작업을 중단한다. (처리 순서는 마찬가지로 보장)

    TimeUtil.start()
    Observable.interval(100L, TimeUnit.MILLISECONDS)
        .take(4)
        .skip(2)
        .doOnNext { Logger.log(LogType.DO_ON_NEXT, it) }
        .switchMap { num ->
            Observable.interval(300L, TimeUnit.MILLISECONDS)
                .take(10)
                .skip(1)
                .map { "$num * $it = ${num * it}" }
        }
        .subscribe { Logger.log(LogType.ON_NEXT, it) }

    Thread.sleep(5000)
}