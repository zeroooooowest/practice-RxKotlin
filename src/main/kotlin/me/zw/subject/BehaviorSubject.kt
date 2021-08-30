package me.zw.subject

import io.reactivex.subjects.BehaviorSubject
import me.zw.utils.LogType
import me.zw.utils.Logger


fun main() {

    // 구독 시점에 이미 통지된 데이터가 있다면, 이미 통지된 데이터의 마지막 데이터를 전달 받은 후, 구독 이후에 통지된 데이터들을 전달받는다.
    // 처리가 완료된 이후에 구독하면, 완료나 에러 통지만 전달 받는다.
    val subject = BehaviorSubject.createDefault(3000)

    subject.subscribe { Logger.log(LogType.ON_NEXT, "# 소비자 1: $it") }
    subject.onNext(3500)

    subject.subscribe { Logger.log(LogType.ON_NEXT, "# 소비자 2: $it") }
    subject.onNext(3300)

    subject.subscribe { Logger.log(LogType.ON_NEXT, "# 소비자 3: $it") }
    subject.onNext(3400)

}