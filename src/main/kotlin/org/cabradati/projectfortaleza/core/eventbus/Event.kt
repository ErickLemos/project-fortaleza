package org.cabradati.projectfortaleza.core.eventbus

interface Event {

    val type: EventType

    fun invoke()

}