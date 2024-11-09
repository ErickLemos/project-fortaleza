package org.cabradati.projectfortaleza

import net.fabricmc.api.ModInitializer
import org.cabradati.projectfortaleza.core.eventbus.EventBus
import org.cabradati.projectfortaleza.events.VillageInitialization
import org.slf4j.LoggerFactory

object ProjectFortaleza : ModInitializer {
    private val logger = LoggerFactory.getLogger("project-fortaleza-bootlog")

    override fun onInitialize() {
        logger.info("project fortaleza - init")
        EventBus.publish(VillageInitialization())
    }

}