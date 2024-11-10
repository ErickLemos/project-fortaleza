package org.cabradati.projectfortaleza.modules.village.event

import org.cabradati.projectfortaleza.core.eventbus.EventManager
import org.cabradati.projectfortaleza.core.utils.ProjectConstants
import org.cabradati.projectfortaleza.core.utils.saveFile
import org.cabradati.projectfortaleza.modules.village.models.Village

object VillageCreationEvent : EventManager {

    fun create(village: Village) {
        saveFile(
            path = "config/${ProjectConstants.NAME}/${village.uuid}",
            fileName = "village.json",
            content = village
        )

        village.villagers.parallelStream().forEach {
            saveFile(
                path = "config/${ProjectConstants.NAME}/${village.uuid}/villagers",
                fileName = "${it.uuid}.json",
                content = it
            )
        }
    }
}