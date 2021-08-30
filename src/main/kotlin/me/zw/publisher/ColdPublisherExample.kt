package me.zw.publisher

import io.reactivex.Flowable


fun main() {
    val flowable = Flowable.just(1, 3, 5, 7)

    flowable.subscribe {
        println("구독자1: $it")
    }

    flowable.subscribe {
        println("구독자2: $it")
    }
}