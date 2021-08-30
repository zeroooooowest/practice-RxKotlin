package me.zw.`do`

import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import me.zw.utils.LogType
import me.zw.utils.Logger


fun main() {

    // 구독 시, 지정된 작업을 처리할 수 있다.
    // onSubscribe() 이벤트 발생하기 직전에 실행.

    Observable.just(1, 2, 3, 4, 5, 6, 7)
        .doOnSubscribe { _: Disposable -> Logger.log(LogType.DO_ON_SUBSCRIBE, "# 생산자: 구독 처리 준비 완료") }
        .subscribe(
            {Logger.log(LogType.ON_NEXT, it)},
            {Logger.log(LogType.ON_ERROR, it)},
            {Logger.log(LogType.ON_COMPLETE)},
            {Logger.log(LogType.ON_SUBSCRIBE, "# 소비자: 구독 처리 준비 완료 알림 받음")}
        )
}