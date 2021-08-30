package me.zw.operator

import io.reactivex.Observable
import me.zw.utils.LogType
import me.zw.utils.Logger
import me.zw.utils.TimeUtil
import java.util.concurrent.TimeUnit

// 생성 연산자: timer
fun main() {

    Logger.log(LogType.PRINT, "# Start!")

    // 지정한 시간이 지나면 0(Long)을 통지하고 onComplete() 이벤트가 발생하여 종료
    // 호출한 스레드와는 별도의 스레드에서 실행
    // 특정 시간을 대기한 후에 어떤 처리를 하고자 할 때 활용 가능
    val observable = Observable.timer(2000, TimeUnit.MILLISECONDS)
        .map { "Do Work!" }

    observable.subscribe { Logger.log(LogType.ON_NEXT, it) }

    TimeUtil.sleep(3000)
}