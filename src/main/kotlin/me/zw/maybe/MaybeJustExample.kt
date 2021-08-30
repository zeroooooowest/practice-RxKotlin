package me.zw.maybe

import io.reactivex.Maybe
import me.zw.utils.DateUtil
import me.zw.utils.LogType
import me.zw.utils.Logger


fun main() {
    Maybe.just(DateUtil.nowDate)
        .subscribe(
            { data -> Logger.log(LogType.ON_SUCCESS, "# 현재 날짜시각: $data") },
            { error -> Logger.log(LogType.ON_ERROR, error) },
            { Logger.log(LogType.ON_COMPLETE) }
        )

    Maybe.empty<String>()
        .subscribe(
            { data -> Logger.log(LogType.ON_SUCCESS, data) },
            { error -> Logger.log(LogType.ON_ERROR, error) },
            { Logger.log(LogType.ON_COMPLETE) }
        )
}