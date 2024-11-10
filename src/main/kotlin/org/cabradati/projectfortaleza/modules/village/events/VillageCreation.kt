package org.cabradati.projectfortaleza.modules.village.events

import org.cabradati.projectfortaleza.core.eventbus.Event
import org.cabradati.projectfortaleza.core.utils.saveFile
import org.cabradati.projectfortaleza.modules.village.models.Village

class VillageCreation(
    val village: Village
) : Event {

    override fun invoke() {

        saveFile(
            path = "config/village/${village.uuid}",
            fileName = "village.json",
            content = village
        )

        village.villagers.parallelStream().forEach {
            saveFile(
                path = "config/village/${village.uuid}/villagers",
                fileName = "${it.uuid}.json",
                content = it
            )
        }
    }

}