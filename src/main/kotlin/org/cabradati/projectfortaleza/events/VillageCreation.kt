package org.cabradati.projectfortaleza.events

import org.cabradati.projectfortaleza.core.eventbus.Event
import org.cabradati.projectfortaleza.core.eventbus.EventType
import org.cabradati.projectfortaleza.core.fileevents.FileEvent
import org.cabradati.projectfortaleza.core.fileevents.FileEventBus
import org.cabradati.projectfortaleza.core.utils.objectMapper
import org.cabradati.projectfortaleza.core.models.Village
import org.cabradati.projectfortaleza.mecanisms.relationship.RelationshipModule

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

        RelationshipModule.registerVillage(village)
    }

}