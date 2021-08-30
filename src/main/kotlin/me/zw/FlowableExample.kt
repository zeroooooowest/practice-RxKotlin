package me.zw

import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.FlowableEmitter
import io.reactivex.schedulers.Schedulers
import me.zw.utils.LogType
import me.zw.utils.Logger
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription


fun main() {
    val flowable = Flowable.create(
        { emitter: FlowableEmitter<String> ->
            val datas = arrayOf("Hello", "RxKotlin!")
            for (data in datas) {
                // 구독이 해지되면 처리 중단
                if (emitter.isCancelled) return@create

                // 데이터 통지
                emitter.onNext(data)
            }

            // 통지 완료를 알린다.
            emitter.onComplete()
        }, BackpressureStrategy.BUFFER
    )


    flowable.observeOn(Schedulers.computation())
        .subscribe(object : Subscriber<String> {
            // 데이터 개수 요청 및 구독을 취소하기 위한 Subscription 객체
            var subscription: Subscription? = null

            override fun onSubscribe(s: Subscription) {
                this.subscription = s
                this.subscription?.request(Long.MAX_VALUE)
            }

            override fun onNext(t: String) {
                Logger.log(LogType.ON_NEXT, t)
            }

            override fun onError(t: Throwable) {
                Logger.log(LogType.ON_ERROR, t)
            }

            override fun onComplete() {
                Logger.log(LogType.ON_COMPLETE)
            }
        })

    Thread.sleep(500L)

}