package org.cabradati.projectfortaleza.commands

import net.minecraft.server.command.CommandManager
import org.cabradati.projectfortaleza.core.eventbus.EventBus
import org.cabradati.projectfortaleza.core.eventbus.publishEvent
import org.cabradati.projectfortaleza.core.utils.command
import org.cabradati.projectfortaleza.events.VillageCreation
import org.cabradati.projectfortaleza.core.models.EconomyBudget
import org.cabradati.projectfortaleza.core.models.Village
import java.util.UUID.randomUUID

object DevCommands {

    private val newVillageEvent = CommandManager.literal("new_village").executes {
        publishEvent(VillageCreation(
            village = Village(
                name = randomUUID().toString(),
                description = "",
                budget = EconomyBudget.EMPTY
            )
        ))
        return@executes 1
    }

    fun registerCommands() {
        command(newVillageEvent)
    }

}