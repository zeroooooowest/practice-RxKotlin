package me.zw.utils

object Logger {
    fun log(msg: String) {
        val time: String = TimeUtil.currentTimeFormatted
        println(msg + " | " + Thread.currentThread().name + " | " + time)
    }

    fun log(msg: String, obj: Any) {
        val time: String = TimeUtil.currentTimeFormatted
        println(msg + " | " + Thread.currentThread().name + " | " + time + " | " + obj)
    }

    fun log(logType: LogType) {
        val time: String = TimeUtil.currentTimeFormatted
        println(logType.logType.toString() + " | " + Thread.currentThread().name + " | " + time)
    }

    fun log(logType: LogType, obj: Any) {
        val time: String = TimeUtil.currentTimeFormatted
        println(logType.logType.toString() + " | " + Thread.currentThread().name + " | " + time + " | " + obj)
    }
}