package me.zw.maybe

import io.reactivex.Maybe
import io.reactivex.MaybeObserver
import io.reactivex.disposables.Disposable
import me.zw.utils.DateUtil
import me.zw.utils.LogType
import me.zw.utils.Logger


fun main() {
    val maybe = Maybe.create<String> { emitter ->
        emitter.onSuccess(DateUtil.nowDate)

//        emitter.onComplete()
    }

    maybe.subscribe(object : MaybeObserver<String> {
        override fun onSubscribe(d: Disposable) {
        }

        override fun onSuccess(t: String) {
            Logger.log(LogType.ON_SUCCESS, "# 현재 날짜시각: $t")
        }

        override fun onError(e: Throwable) {
            Logger.log(LogType.ON_ERROR, e)
        }

        override fun onComplete() {
            Logger.log(LogType.ON_COMPLETE)
        }
    })


}