package org.cabradati.projectfortaleza.events

import org.cabradati.projectfortaleza.core.eventbus.Event
import org.cabradati.projectfortaleza.core.eventbus.EventType
import org.cabradati.projectfortaleza.core.utils.log

class VillageCreation: Event {
    override val type = EventType.CORE
    override fun invoke() {
        log("${Thread.currentThread()} initialization event")
    }
}