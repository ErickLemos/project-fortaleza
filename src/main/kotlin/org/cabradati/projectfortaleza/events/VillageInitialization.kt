package org.cabradati.projectfortaleza.events

import org.cabradati.projectfortaleza.core.Event
import org.cabradati.projectfortaleza.core.eventbus.EventType
import org.cabradati.projectfortaleza.core.log

class VillageInitialization: Event {
    override val type = EventType.CORE
    override fun invoke() {
        log("${Thread.currentThread().name} initialization event")
    }
}