package org.cabradati.projectfortaleza.events

import org.cabradati.projectfortaleza.core.eventbus.Event
import org.cabradati.projectfortaleza.core.eventbus.EventType
import org.cabradati.projectfortaleza.core.eventbus.file.FileEvent
import org.cabradati.projectfortaleza.core.eventbus.file.FileEventBus
import org.cabradati.projectfortaleza.core.utils.objectMapper
import org.cabradati.projectfortaleza.models.Village

class VillageCreation(
    val village: Village
) : Event {
    override val type = EventType.CORE

    override fun invoke() {
        FileEventBus.publish(
            FileEvent(
                name = "${village.uuid}.json",
                content = objectMapper.writeValueAsString(village)
            )
        )
    }

}