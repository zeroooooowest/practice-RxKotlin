package me.zw.operator

import io.reactivex.Observable
import me.zw.utils.LogType
import me.zw.utils.Logger
import me.zw.utils.TimeUtil
import java.util.concurrent.TimeUnit

// 데이터 변환 연산자: concatMap
fun main() {

    // flatMap 과 마찬가지로 받은 데이터를 변환하여 새로운 Observable 로 반환
    // 반환된 새로운 Observable 을 하나씩 순서대로 실행하는 것이 flatMap 과 다르다. (처리 순서 보장)

    TimeUtil.start()
    Observable.interval(100L, TimeUnit.MILLISECONDS)
        .take(4)
        .skip(2)
        .concatMap { num ->
            Observable.interval(200L, TimeUnit.MILLISECONDS)
                .take(10)
                .skip(1)
                .map { "$num * $it = ${num * it}" }
        }.subscribe(
            { Logger.log(LogType.ON_NEXT, it) },
            {},
            {
                TimeUtil.end()
                TimeUtil.takeTime()
            }
        )

    TimeUtil.sleep(5000L)

}