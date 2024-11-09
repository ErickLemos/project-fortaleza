package org.cabradati.projectfortaleza.core.eventbus

import org.cabradati.projectfortaleza.events.VillageInitialization
import org.junit.jupiter.api.Test

class EventBusTest {

    @Test
    fun algo() {
        EventBus.publish(VillageInitialization())
    }
}