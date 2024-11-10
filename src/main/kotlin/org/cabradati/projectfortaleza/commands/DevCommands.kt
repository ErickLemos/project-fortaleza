package org.cabradati.projectfortaleza.commands

import net.minecraft.server.command.CommandManager
import org.cabradati.projectfortaleza.core.eventbus.publishEvent
import org.cabradati.projectfortaleza.core.utils.command
import org.cabradati.projectfortaleza.modules.village.events.VillageCreation
import org.cabradati.projectfortaleza.modules.village.models.EconomyBudget
import org.cabradati.projectfortaleza.modules.village.models.Village

object DevCommands {

    private val newVillageEvent = CommandManager.literal("new_village").executes {
        publishEvent(
            VillageCreation(
                village = Village(
                    name = "teste",
                    description = "",
                    budget = EconomyBudget.EMPTY
                )
            )
        )
        return@executes 1
    }

    fun registerCommands() {
        command(newVillageEvent)
    }

}