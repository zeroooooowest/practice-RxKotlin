package me.zw.`do`

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import me.zw.common.CarMaker
import me.zw.common.SampleData
import me.zw.utils.LogType
import me.zw.utils.Logger
import me.zw.utils.TimeUtil
import java.util.concurrent.TimeUnit


fun main() {

    // 소비자가 구독을 해지하는 시점에, 지정된 작업을 처리할 수 있다.
    // 완료나 에러로 종료될 경우에는 실행되지 않는다.

    Observable.fromIterable(SampleData.carMakers.toList())
        .zipWith(Observable.interval(300L, TimeUnit.MILLISECONDS)) { carMaker, num -> carMaker }
        .doOnDispose { Logger.log(LogType.DO_ON_DISPOSE, "# 생산자: 구독 해지 완료") }
        .subscribe(object : Observer<CarMaker> {
            var disposable: Disposable? = null
            var startTime: Long = 0

            override fun onSubscribe(d: Disposable) {
                disposable = d
                startTime = TimeUtil.start()
            }

            override fun onNext(t: CarMaker) {
                Logger.log(LogType.ON_NEXT, t)
                if (TimeUtil.currentTime - startTime > 1000L) {
                    Logger.log(LogType.PRINT, "# 소비자: 구독 해지, 1000L 초과")
                    disposable?.dispose()
                }
            }

            override fun onError(e: Throwable) {
                Logger.log(LogType.ON_ERROR, e)
            }

            override fun onComplete() {
                Logger.log(LogType.ON_COMPLETE)
            }
        })

    TimeUtil.sleep(2000L)
}