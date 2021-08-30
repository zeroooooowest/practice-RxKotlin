package me.zw.utils

enum class LogType(val logType: String) {
    ON_SUBSCRIBE("onSubscribe()"), ON_NEXT("onNext()"), ON_ERROR("onERROR()"), ON_COMPLETE("onComplete()"), ON_SUCCESS("onSuccess()"), DO_ON_SUBSCRIBE(
        "doOnSubscribe()"
    ),
    DO_ON_NEXT("doOnNext()"), DO_ON_COMPLETE("doOnComplete()"), DO_ON_EACH("doOnEach()"), DO_ON_DISPOSE("doOnDispose()"), DO_ON_ERROR(
        "donOnError()"
    ),
    PRINT("print()");

}
