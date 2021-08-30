package me.zw.maybe

import io.reactivex.Maybe
import io.reactivex.Single
import me.zw.utils.DateUtil
import me.zw.utils.LogType
import me.zw.utils.Logger


fun main() {
    val single = Single.just(DateUtil.nowDate)

    Maybe.fromSingle(single)
        .subscribe(
            { data -> Logger.log(LogType.ON_SUCCESS, "# 현재 날짜시각: $data") },
            { error -> Logger.log(LogType.ON_ERROR, error) },
            { Logger.log(LogType.ON_COMPLETE) }
        )
}