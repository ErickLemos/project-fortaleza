package org.cabradati.projectfortaleza.modules.village.events

import org.cabradati.projectfortaleza.core.eventbus.Event
import org.cabradati.projectfortaleza.core.utils.ProjectConstants
import org.cabradati.projectfortaleza.core.utils.saveFile
import org.cabradati.projectfortaleza.modules.village.models.Village

class VillageCreation(
    val village: Village
) : Event {

    override fun invoke() {
        val threadName = "${ProjectConstants.NAME}-event-villagecreation-${village.uuid}"

        saveFile(
            path = "config/${ProjectConstants.NAME}/${village.uuid}",
            fileName = "village.json",
            content = village,
            threadName = threadName
        )

        village.villagers.parallelStream().forEach {
            saveFile(
                path = "config/${ProjectConstants.NAME}/${village.uuid}/villagers",
                fileName = "${it.uuid}.json",
                content = it,
                threadName = threadName
            )
        }
    }

}