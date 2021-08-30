package me.zw.common

class Car {
    lateinit var carMaker: CarMaker
    private var carType: CarType? = null
    var carName: String
    var carPrice = 0
    var isNew = false

    constructor(carName: String) {
        this.carName = carName
    }

    constructor(carName: String, carType: CarType?) {
        this.carName = carName
        this.carType = carType
    }

    constructor(carMaker: CarMaker, carName: String, carType: CarType?, carPrice: Int) {
        this.carMaker = carMaker
        this.carName = carName
        this.carType = carType
        this.carPrice = carPrice
    }

    constructor(carMaker: CarMaker, carType: CarType?, carName: String, carPrice: Int, isNew: Boolean) {
        this.carMaker = carMaker
        this.carType = carType
        this.carName = carName
        this.carPrice = carPrice
        this.isNew = isNew
    }


    fun getCarType(): CarType? {
        return carType
    }

    fun setCarType(carType: CarType?) {
        this.carType = carType
    }
}