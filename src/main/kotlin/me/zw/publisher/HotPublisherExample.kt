package me.zw.publisher

import io.reactivex.processors.PublishProcessor

// Processor 와 Subject 는 Hot publisher.
// Processor 는 배압 기능이 있고 Subject 는 없다.
fun main() {

    // Processor 는 Reactive Streams 에서 정의한 Publisher 인터페이스와 Subscriber 인터페이스를 둘 다 상속한 확장 인터페이스.
    // 즉, 생산자(Publisher)의 기능과 소비자(Subscriber)의 기능을 모두 가지고 있다.
    val processor = PublishProcessor.create<Int>()

    processor.subscribe { println("구독자1: $it") }
    processor.onNext(1)
    processor.onNext(3)

    processor.subscribe { println("구독자2: $it") }
    processor.onNext(5)
    processor.onNext(7)

    processor.onComplete()
}