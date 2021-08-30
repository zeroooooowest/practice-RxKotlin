package me.zw.operator

import io.reactivex.Observable
import me.zw.common.SampleData
import me.zw.utils.LogType
import me.zw.utils.Logger


// 데이터 집계 연산자: count
fun main() {

    // Observable 이 통지한 데이터의 총 갯수를 Single 로 통지.
    // 데이터의 총 갯수를 통지하는 시점은 완료 통지를 받은 시점.

    Observable.concat(
        listOf(
            Observable.fromIterable(SampleData.seoulPM10List),
            Observable.fromIterable(SampleData.busanPM10List),
            Observable.fromIterable(SampleData.incheonPM10List)
        )
    )
        .count()
        .subscribe { data -> Logger.log(LogType.ON_NEXT, data) }

}