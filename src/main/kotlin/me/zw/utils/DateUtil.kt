package me.zw.utils

import java.text.SimpleDateFormat
import java.util.*


object DateUtil {
    val nowDate: String
        get() = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
            .format(Calendar.getInstance().time)
}
