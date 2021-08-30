package me.zw.operator

import io.reactivex.Observable
import me.zw.common.SampleData
import me.zw.utils.LogType
import me.zw.utils.Logger


// 데이터 변환 연산자: groupBy
fun main() {

    // 하나의 Observable 을 여러 개의 새로운 GroupedByObservable 로 만든다.
    // 각각의 데이터들이 그룹에 해당하는 Key 를 가지게 된다 (getKey() 를 통해 구분된 그룹을 알 수 있게 된다)

    val observable = Observable.fromIterable(SampleData.carList)
        .groupBy { it.carMaker }

    observable.subscribe { groupedObservable ->
        groupedObservable.subscribe {
            Logger.log(
                LogType.ON_NEXT,
                "Group: ${groupedObservable.key} \t Car name: ${it.carName}"
            )
        }
    }

}