package me.zw.operator

import io.reactivex.Observable
import me.zw.utils.LogType
import me.zw.utils.Logger
import java.time.LocalDateTime


// 생성 연산자: defer
fun main() {

    // 구독이 발생할 때마다(subscribe()가 호출될 때마다) 새로운 Observable 을 생성한다.
    // 선언한 시점의 데이터를 통지하는 것이 아니라 호출 시점의 데이터를 통지한다.
    // 데이터 생성을 미루는 효과가 있기 때문에 최신 데이터를 얻고자 할 때 활용 가능.
    val observable = Observable.defer {
        val currentTime = LocalDateTime.now()
        Observable.just(currentTime)
    }

    val observableJust = Observable.just(LocalDateTime.now())

    observable.subscribe { time -> Logger.log(LogType.PRINT, "# defer() 구독 1의 구독 시간: $time") }
    observableJust.subscribe { time -> Logger.log(LogType.PRINT, "# just() 구독 1의 구독 시간: $time") }

    Thread.sleep(3000)

    observable.subscribe { time -> Logger.log(LogType.PRINT, "# defer() 구독 2의 구독 시간: $time") }
    observableJust.subscribe { time -> Logger.log(LogType.PRINT, "# just() 구독 2의 구독 시간: $time") }

}