package org.cabradati.projectfortaleza.modules.village.models

import java.util.UUID

class Village(
    val uuid: String = UUID.randomUUID().toString(),
    var name: String,
    var description: String,
    var budget: EconomyBudget
)