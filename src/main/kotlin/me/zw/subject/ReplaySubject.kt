package me.zw.subject

import io.reactivex.subjects.ReplaySubject
import me.zw.utils.LogType
import me.zw.utils.Logger


fun main() {

    // 구독 시점에 이미 통지된 데이터가 있다면,
    // 이미 통지된 데이터 중에서 최근 통지된 데이터를 지정한 갯수(또는 전부)만큼 전달 받은 후, 구독 이후 통지된 데이터들을 전달 받는다.
    // 이미 처리가 완료된 이후에 구독하더라도 지정한 갯수만큼의 최근 통지된 데이터를 전달받는다.

    val subject = ReplaySubject.create<Int>()
//    val subject = ReplaySubject.createWithSize<2)>()
    subject.onNext(3000)
    subject.onNext(2500)

    subject.subscribe { Logger.log(LogType.ON_NEXT, "# 소비자 1: $it") }
    subject.onNext(3500)

    subject.subscribe { Logger.log(LogType.ON_NEXT, "# 소비자 2: $it") }
    subject.onNext(3300)

    subject.onComplete()

    subject.subscribe { Logger.log(LogType.ON_NEXT, "# 소비자 3: $it") }

}