package me.zw

import io.reactivex.Observable


fun main() {
    val observable = Observable.just("Hello", "RxKotlin")
    observable.subscribe {
        println(it)
    }
}