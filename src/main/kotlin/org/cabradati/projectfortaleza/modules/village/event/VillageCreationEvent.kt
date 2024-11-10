package org.cabradati.projectfortaleza.modules.village.event

import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.BehaviorSubject
import org.cabradati.projectfortaleza.core.eventbus.EventManager
import org.cabradati.projectfortaleza.core.utils.ProjectConstants
import org.cabradati.projectfortaleza.core.utils.saveFile
import org.cabradati.projectfortaleza.modules.village.models.Village

object VillageCreationEvent : EventManager {
    private val queue = BehaviorSubject.create<Village>()
    override fun register() {
        queue.observeOn(Schedulers.computation())
            .subscribe { village ->
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

    fun create(village: Village) {
        queue.onNext(village)
    }
}