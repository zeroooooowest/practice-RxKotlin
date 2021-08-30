package me.zw.completable

import io.reactivex.Completable
import io.reactivex.schedulers.Schedulers
import me.zw.utils.LogType
import me.zw.utils.Logger
import me.zw.utils.TimeUtil


fun main() {

    val completable = Completable.create { completableEmitter ->
        // 데이터를 통지하는 것이 아니라 특정 작업을 수행 후 완료를 통지한다.
        val sum = (0 until 100).sum()

        Logger.log(LogType.PRINT, "# 합계: $sum")

        completableEmitter.onComplete()
    }

    completable.subscribeOn(Schedulers.computation())
        .subscribe(
            { Logger.log(LogType.ON_COMPLETE) },
            { error -> Logger.log(LogType.ON_ERROR, error) }
        )

    TimeUtil.sleep(100L)

}