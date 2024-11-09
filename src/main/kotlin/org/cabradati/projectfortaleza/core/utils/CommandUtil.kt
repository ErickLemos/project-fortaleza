package org.cabradati.projectfortaleza.core.utils

import com.mojang.brigadier.builder.LiteralArgumentBuilder
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback
import net.minecraft.server.command.ServerCommandSource

fun command(command: LiteralArgumentBuilder<ServerCommandSource>) {
    CommandRegistrationCallback.EVENT.register { dispatcher, _, _ ->
        dispatcher.register(command)
    }
}