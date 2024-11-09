package org.cabradati.projectfortaleza.core.eventbus

import org.cabradati.projectfortaleza.events.VillageCreation
import org.junit.jupiter.api.Test

class EventBusTest {

    @Test
    fun algo() {
        EventBus.publish(VillageCreation())
    }
}