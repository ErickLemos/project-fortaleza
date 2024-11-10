package org.cabradati.projectfortaleza.modules.village.models

import java.util.UUID

class Villager(
    val name: String,
    val uuid: String = UUID.randomUUID().toString()
)