package me.zw.common

import io.reactivex.Observable
import java.util.Arrays
import java.util.concurrent.TimeUnit


object SampleData {
    var carMakersDuplicated = Arrays.asList(
        CarMaker.CHEVROLET,
        CarMaker.HYUNDAE,
        CarMaker.SAMSUNG,
        CarMaker.SSANGYOUNG,
        CarMaker.CHEVROLET,
        CarMaker.HYUNDAE,
        CarMaker.KIA,
        CarMaker.SSANGYOUNG
    )
    var carMakers = arrayOf(
        CarMaker.CHEVROLET,
        CarMaker.HYUNDAE,
        CarMaker.SAMSUNG,
        CarMaker.SSANGYOUNG,
        CarMaker.KIA
    )
    var carList = Arrays.asList(
        Car(CarMaker.CHEVROLET, "말리부", CarType.SEDAN, 23000000),
        Car(CarMaker.HYUNDAE, "쏘렌토", CarType.SUV, 33000000),
        Car(CarMaker.CHEVROLET, "트래버스", CarType.SUV, 50000000),
        Car(CarMaker.HYUNDAE, "팰리세이드", CarType.SEDAN, 28000000),
        Car(CarMaker.CHEVROLET, "트랙스", CarType.SUV, 18000000),
        Car(CarMaker.SSANGYOUNG, "티볼리", CarType.SUV, 23000000),
        Car(CarMaker.SAMSUNG, "SM6", CarType.SUV, 40000000),
        Car(CarMaker.SSANGYOUNG, "G4렉스턴", CarType.SUV, 43000000),
        Car(CarMaker.SAMSUNG, "SM5", CarType.SEDAN, 35000000)
    )

    // A, B, C 구간의 차량 속도 데이터
    val speedOfSectionA = arrayOf(100, 110, 115, 130, 160)
    val speedOfSectionB = arrayOf(85, 90, 100, 110, 105, 113, 125)
    val speedOfSectionC = arrayOf(98, 88, 111, 123, 155, 124, 136, 143)

    // 지점 A의 월별 매출
    val salesOfBranchA = Arrays.asList(
        15000000, 25000000, 10000000, 35000000, 23000000, 40000000, 50000000, 45000000,
        35000000, 23000000, 15000000, 10000000
    )

    // 지점 B의 월별 매출
    val salesOfBranchB = Arrays.asList(
        11000000, 23000000, 15000000, 32000000, 13000000, 45000000, 55000000, 43000000,
        25000000, 28000000, 19000000, 13000000
    )

    // 지점 C의 월별 매출
    val salesOfBranchC = Arrays.asList(
        12000000, 21000000, 19000000, 33000000, 33000000, 41000000, 52000000, 48000000,
        32000000, 21000000, 18000000, 14000000
    )

    // 서울의 시간별 미세먼지 농도
    val seoulPM10List = Arrays.asList(
        45, 30, 68, 70, 100, 110, 120, 90, 80, 60, 50, 60, 70, 80, 100, 150, 140, 130, 170, 130, 90, 86, 67, 50
    )

    // 부산의 시간별 미세먼지 농도
    val busanPM10List = Arrays.asList(
        35, 30, 63, 50, 80, 90, 100, 80, 70, 50, 55, 60, 65, 75, 80, 90, 100, 90, 120, 110, 70, 66, 65, 55
    )

    // 인천의 시간별 미세먼지 농도
    val incheonPM10List = Arrays.asList(
        55, 40, 73, 70, 85, 99, 120, 85, 75, 73, 80, 70, 95, 95, 100, 120, 110, 120, 140, 120, 100, 125, 135, 125
    )

    // 1시간 동안 서울의 온도 변화 데이터
    var temperatureOfSeoul = arrayOf(10, 13, 14, 12, 11, 9)

    // 1시간 동안 서울의 습도 변화 데이터
    var humidityOfSeoul = arrayOf(45, 35, 33, 43, 32, 62)
    fun getSpeedPerSection(section: String, interval: Long, speedData: Array<Int>): Observable<String> {
        return Observable.interval(interval, TimeUnit.MILLISECONDS)
            .take(speedData.size.toLong())
            .map { i -> section + " 지점의 차량 속도: " + speedData[i.toInt()] }
    }
}