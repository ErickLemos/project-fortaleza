package org.cabradati.projectfortaleza.core

import org.cabradati.projectfortaleza.core.eventbus.EventType

interface Event {

    val type: EventType

    fun invoke()

}