package org.cabradati.projectfortaleza.commands

import net.minecraft.server.command.CommandManager
import org.cabradati.projectfortaleza.core.eventbus.EventBus
import org.cabradati.projectfortaleza.core.utils.command
import org.cabradati.projectfortaleza.events.VillageCreation

object DevCommands {

    private val newVillageEvent = CommandManager.literal("new_village").executes {
        EventBus.publish(VillageCreation())
        return@executes 1
    }

    fun registerCommands() {
        command(newVillageEvent)
    }

}