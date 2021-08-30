package me.zw.operator

import io.reactivex.Observable
import me.zw.common.Searcher
import me.zw.utils.LogType
import me.zw.utils.Logger
import me.zw.utils.TimeUtil
import java.util.concurrent.TimeUnit


fun main() {

    TimeUtil.start()
    val searcher = Searcher()
    val keywords = listOf("M", "Ma", "Mal", "Malay")    // 사용자가 입력하는 검색어라 가정

    Observable.interval(100L, TimeUnit.MILLISECONDS)
        .take(4)
//        .concatMap { data ->
//            Observable.just(searcher.search(keywords.get(data.toInt())))
//                .doOnNext { Logger.log(LogType.DO_ON_NEXT, "=============") }
//                .delay(1000L, TimeUnit.MILLISECONDS)
//        }     // concatMap 을 사용하면 비효율적이다.
        .switchMap { data ->
            Observable.just(
                searcher.search(keywords.get(data.toInt()))
            )
                .doOnNext { Logger.log(LogType.DO_ON_NEXT, "=============") }
                .delay(1000L, TimeUnit.MILLISECONDS)
        }
        .flatMap { Observable.fromIterable(it) }
        .subscribe(
            { Logger.log(LogType.ON_NEXT, it) },
            {},
            {
                TimeUtil.end()
                TimeUtil.takeTime()
            }
        )

    TimeUtil.sleep(6000L)
}