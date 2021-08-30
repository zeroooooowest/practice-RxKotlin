package me.zw.operator

import io.reactivex.Observable
import io.reactivex.observables.GroupedObservable
import me.zw.common.Car
import me.zw.common.CarMaker
import me.zw.common.SampleData
import me.zw.utils.LogType
import me.zw.utils.Logger

// 데이터 변환 연산자: flatMapSingle
fun main() {

    // Observable<GroupedObservable> 처럼 Observable 이 이중으로 감싸져 있는 경우
    // 바깥쪽 Observable 을 벗겨내고 GroupedObservable 로 평탄화 시켜주는 역할
    // flatMap 처럼 새로운 Observable 로 데이터를 여러번 emit 하는 것이 아니라 Single Observable 로 딱 한번 emit.

    val observable: Observable<GroupedObservable<CarMaker, Car>> =
        Observable.fromIterable(SampleData.carList)
            .groupBy { it.carMaker }

    observable.flatMapSingle { carGroup: GroupedObservable<CarMaker, Car> ->
        carGroup.flatMap { car: Car ->
            Observable.just(car.carName)
        }.toList()
    }.subscribe { Logger.log(LogType.ON_NEXT, it) }

}