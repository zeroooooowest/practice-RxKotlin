package me.zw.operator

import io.reactivex.Observable
import me.zw.utils.LogType
import me.zw.utils.Logger

// 데이터 집계 연산자: scan
fun main() {

    // 문자열의 처리 중간 결과를 계속해서 출력한다

    Observable.just("a", "b", "c", "d", "e")
        .doOnNext { Logger.log(LogType.DO_ON_NEXT, it) }
        .scan { t1, t2 -> "($t1, $t2)" }
        .subscribe { Logger.log(LogType.ON_NEXT, "# 출력 결과: $it") }

}