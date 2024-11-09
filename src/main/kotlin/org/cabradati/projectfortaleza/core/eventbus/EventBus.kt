package org.cabradati.projectfortaleza.core.eventbus

import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.BehaviorSubject

object EventBus {
    private val queue = BehaviorSubject.create<Event>()

    init {
        queue.subscribeOn(Schedulers.computation())
            .subscribe { it.invoke() }
    }

    fun publish(event: Event) {
        queue.onNext(event)
    }

}