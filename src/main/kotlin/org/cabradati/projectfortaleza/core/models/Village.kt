package org.cabradati.projectfortaleza.core.models

import java.util.UUID.randomUUID

class Village(
    val uuid: String = randomUUID().toString(),
    val name: String,
    val description: String,
    val budget: EconomyBudget
)