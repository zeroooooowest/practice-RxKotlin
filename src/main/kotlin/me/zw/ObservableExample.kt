package me.zw

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import me.zw.utils.LogType
import me.zw.utils.Logger

fun main() {

    val observable = Observable.create<String> { emitter ->
        val datas = arrayOf("Hello", "RxKotlin")
        for (data in datas) {
            // 구독이 해지되면 처리 중단
            if (emitter.isDisposed) return@create

            // 데이터 통지
            emitter.onNext(data)
        }

        // 통지 완료를 알린다.
        emitter.onComplete()
    }


    observable.observeOn(Schedulers.computation())
        .subscribe(object : Observer<String> {
            override fun onSubscribe(d: Disposable) {
            }

            override fun onNext(t: String) {
                Logger.log(LogType.ON_NEXT, t)
            }

            override fun onError(e: Throwable) {
                Logger.log(LogType.ON_ERROR, e)
            }

            override fun onComplete() {
                Logger.log(LogType.ON_COMPLETE)
            }
        })

    Thread.sleep(500L)
}