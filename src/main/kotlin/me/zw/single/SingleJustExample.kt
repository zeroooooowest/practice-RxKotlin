package me.zw.single

import io.reactivex.Single
import me.zw.utils.DateUtil
import me.zw.utils.LogType
import me.zw.utils.Logger

fun main() {
    Single.just(DateUtil.nowDate)
        .subscribe(
            { data -> Logger.log(LogType.ON_SUCCESS, "# 날짜시각: $data") },
            { error -> Logger.log(LogType.ON_ERROR, error) }
        )
}