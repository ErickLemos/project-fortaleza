package org.cabradati.projectfortaleza.commands

import net.minecraft.server.command.CommandManager
import org.cabradati.projectfortaleza.core.utils.command
import org.cabradati.projectfortaleza.modules.village.event.VillageCreationEvent
import org.cabradati.projectfortaleza.modules.village.models.Village

object DevCommands {

    private val newVillageEvent = CommandManager.literal("new_village").executes {
        VillageCreationEvent.create(Village(Thread.currentThread().name))
        return@executes 1
    }

    fun registerCommands() {
        command(newVillageEvent)
    }

}