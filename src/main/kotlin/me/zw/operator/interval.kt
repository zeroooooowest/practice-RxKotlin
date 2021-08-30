package me.zw.operator

import io.reactivex.Observable
import me.zw.utils.LogType
import me.zw.utils.Logger
import me.zw.utils.TimeUtil
import java.util.concurrent.TimeUnit

// 생성 연산자: interval
fun main() {

    // 지정한 시간 간격마다 0부터 시작하는 숫자(Long)을 완료 없이 계속 통지. (initialDelay 이용해 최초 통지에 대한 대기시간 설정 가능)
    // 호출한 스레드와 별도의 스레드에서 실행
    // polling 용도의 작업을 수행할 때 활용할 수 있다.
    Observable.interval(0L, 1000L, TimeUnit.MILLISECONDS)
        .map { "$it count" }
        .subscribe { Logger.log(LogType.ON_NEXT, it) }

    TimeUtil.sleep(3000)
}