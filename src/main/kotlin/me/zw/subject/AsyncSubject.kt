package me.zw.subject

import io.reactivex.subjects.AsyncSubject
import me.zw.utils.LogType
import me.zw.utils.Logger


fun main() {

    // 완료 전까지 아무것도 통지하고 있지 않다가 완료했을 때 마지막으로 통지한 데이터와 완료만 통지.
    // 즉, 모든 소비자는 구독 시점에 상관없이 마지막으로 통지된 데이터와 완료 통지만 받는다.
    // 완료 후에 구독한 소비자라도 마지막으로 통지된 데이터와 완료 통지를 받는다.

    val subject = AsyncSubject.create<Int>()
    subject.onNext(1000)

    subject.doOnNext { Logger.log(LogType.DO_ON_NEXT, "# 소비자 1: $it") }
        .subscribe { Logger.log(LogType.ON_NEXT, "# 소비자 1 : $it") }
    subject.onNext(2000)

    subject.doOnNext { Logger.log(LogType.DO_ON_NEXT, "# 소비자 2: $it") }
        .subscribe { Logger.log(LogType.ON_NEXT, "# 소비자 2: $it") }
    subject.onNext(3000)

    subject.doOnNext { Logger.log(LogType.DO_ON_NEXT, "# 소비자 3: $it") }
        .subscribe { Logger.log(LogType.ON_NEXT, "# 소비자 3: $it") }
    subject.onNext(4000)

    subject.onComplete()

    subject.doOnNext { Logger.log(LogType.DO_ON_NEXT, "# 소비자 4: $it") }
        .subscribe { Logger.log(LogType.ON_NEXT, "# 소비자 4: $it") }

}