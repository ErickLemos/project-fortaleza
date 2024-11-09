package org.cabradati.projectfortaleza

import net.fabricmc.api.ModInitializer
import org.cabradati.projectfortaleza.commands.DevCommands
import org.cabradati.projectfortaleza.mecanisms.relationship.RelationshipModule
import org.slf4j.LoggerFactory

object ProjectFortaleza : ModInitializer {
    private val logger = LoggerFactory.getLogger("project-fortaleza-bootlog")

    override fun onInitialize() {
        logger.info("project fortaleza - init")

        DevCommands.registerCommands()

        // Modules
        RelationshipModule.init()
    }

}