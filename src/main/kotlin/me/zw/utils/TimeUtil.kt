package me.zw.utils

import java.time.LocalTime
import java.time.format.DateTimeFormatter


object TimeUtil {
    var start: Long = 0
    var end: Long = 0
    val formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS")
    fun start(): Long {
        start = System.currentTimeMillis()
        return start
    }

    fun end() {
        end = System.currentTimeMillis()
    }

    fun takeTime() {
        println("# 실행시간: " + (end - start) + " ms")
    }

    val currentTimeFormatted: String
        get() = LocalTime.now().format(formatter)
    val currentTime: Long
        get() = System.currentTimeMillis()

    fun sleep(interval: Long) {
        try {
            Thread.sleep(interval)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }
}