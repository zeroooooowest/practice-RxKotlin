package me.zw.operator

import io.reactivex.Observable
import me.zw.common.SampleData
import me.zw.utils.LogType
import me.zw.utils.Logger
import me.zw.utils.TimeUtil
import java.util.concurrent.TimeUnit


// 조건 연산자: amb
fun main() {

    // 여러 개의 Observable 중에서 최초 통지 시점이 가장 빠른 Observable 의 데이터만 통지되고 나머지는 무시.
    Observable.amb(
        listOf(
            Observable.fromIterable(SampleData.salesOfBranchA)
                .delay(200L, TimeUnit.MILLISECONDS)
                .doOnComplete { Logger.log(LogType.DO_ON_COMPLETE, "# branch A's sales") },
            Observable.fromIterable(SampleData.salesOfBranchB)
                .delay(300L, TimeUnit.MILLISECONDS)
                .doOnComplete { Logger.log(LogType.DO_ON_COMPLETE, "# branch B's sales") },
            Observable.fromIterable(SampleData.salesOfBranchC)
                .delay(500L, TimeUnit.MILLISECONDS)
                .doOnComplete { Logger.log(LogType.DO_ON_COMPLETE, "# branch C's sales") }
        )
    )
        .doOnComplete { Logger.log(LogType.DO_ON_COMPLETE, "# 완료") }
        .subscribe { Logger.log(LogType.ON_NEXT, it) }

    TimeUtil.sleep(1000L)
}