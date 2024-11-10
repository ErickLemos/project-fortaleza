package org.cabradati.projectfortaleza

import net.fabricmc.api.ModInitializer
import org.cabradati.projectfortaleza.commands.DevCommands
import org.cabradati.projectfortaleza.modules.village.VillageManagerModule
import org.slf4j.LoggerFactory


object ProjectFortaleza : ModInitializer {

    private val logger = LoggerFactory.getLogger("project-fortaleza-bootlog")

    override fun onInitialize() {
        logger.info("initializing project-fortaleza")
        DevCommands.registerCommands()
        VillageManagerModule.init()
        logger.info("project-fortaleza initialized successfully")
    }

}