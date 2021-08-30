package me.zw.subject

import io.reactivex.subjects.PublishSubject
import me.zw.utils.LogType
import me.zw.utils.Logger


// PublishSubject
fun main() {

    // 구독 전에 통지된 데이터는 받을 수 없고, 구독한 이후에 통지된 데이터만 받을 수 있다.
    // 데이터 통지가 완료된 이후에는 소비자가 구독하면 완료 또는 에러 통지를 받게 된다.

    val subject: PublishSubject<Int> = PublishSubject.create()

    subject.subscribe { Logger.log(LogType.ON_NEXT, "# 소비자 1 : $it") }
    subject.onNext(3500)
    subject.subscribe { Logger.log(LogType.ON_NEXT, "# 소비자 2: $it") }
    subject.onNext(3300)
    subject.subscribe { Logger.log(LogType.ON_NEXT, "# 소비자 3: $it") }
    subject.onNext(3400)

    subject.subscribe(
        { Logger.log(LogType.ON_NEXT, "# 소비자 4 : $it") },
        { Logger.log(LogType.ON_ERROR, it) },
        { Logger.log(LogType.ON_COMPLETE) }
    )

    subject.onComplete()
}