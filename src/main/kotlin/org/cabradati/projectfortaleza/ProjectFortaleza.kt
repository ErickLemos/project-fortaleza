package org.cabradati.projectfortaleza

import net.fabricmc.api.ModInitializer
import org.cabradati.projectfortaleza.commands.DevCommands
import org.cabradati.projectfortaleza.core.database.DatabaseConfig
import org.cabradati.projectfortaleza.modules.village.VillagerManagerModule
import org.dizitart.kno2.documentOf
import org.slf4j.LoggerFactory

object ProjectFortaleza : ModInitializer {
    private val logger = LoggerFactory.getLogger("project-fortaleza-bootlog")

    override fun onInitialize() {
        logger.info("project fortaleza - init")
        DatabaseConfig.init()
        DatabaseConfig.db.getCollection("teste")
            .insert(
                documentOf(
                    "name" to "algo"
                )
            )

        DevCommands.registerCommands()
        VillagerManagerModule.init()
    }

}