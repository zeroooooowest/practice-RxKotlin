package me.zw.operator

import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.observables.GroupedObservable
import me.zw.common.Car
import me.zw.common.CarMaker
import me.zw.common.SampleData
import me.zw.utils.LogType
import me.zw.utils.Logger


// 데이터 집계 연산자: reduce
fun main() {

    val observable: Observable<GroupedObservable<CarMaker, Car>> =
        Observable.fromIterable(SampleData.carList)
            .groupBy { it.carMaker }

    observable.flatMapSingle { carGroup: GroupedObservable<CarMaker, Car> ->
        Single.just(carGroup.key)
            .zipWith(
                carGroup.flatMap { car ->
                    Observable.just(car.carPrice)
                }
                    .reduce { p1, p2 -> p1 + p2 }
                    .toSingle()
            ) { key, sum -> "$key: $sum" }
    }
        .subscribe { Logger.log(LogType.ON_NEXT, it) }
}