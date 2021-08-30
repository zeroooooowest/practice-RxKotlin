package me.zw.operator

import io.reactivex.Observable
import me.zw.utils.LogType
import me.zw.utils.Logger
import me.zw.utils.TimeUtil
import java.util.concurrent.CompletableFuture

// 생성 연산자: fromFuture
fun main() {

    Logger.log(LogType.PRINT, "# start time")

    // 긴 처리 시간이 걸리는 작업
    val future = CompletableFuture.supplyAsync { calculate() }

    // 짧은 처리 시간이 걸리는 작업
    shortTimeWork()

    Observable.fromFuture(future)
        .subscribe { Logger.log(LogType.PRINT, "# 긴 처리 시간 작업 결과: $it") }

    Logger.log(LogType.PRINT, "# end Time")
}

private fun calculate(): Double {
    Logger.log(LogType.PRINT, "# 긴 처리 시간이 걸리는 작업 중 ........")
    TimeUtil.sleep(6000L)
    return 100000000000000.0
}

private fun shortTimeWork() {
    TimeUtil.sleep(2000L)
    Logger.log(LogType.PRINT, "# 짧은 처리 시간 작업 완료")
}