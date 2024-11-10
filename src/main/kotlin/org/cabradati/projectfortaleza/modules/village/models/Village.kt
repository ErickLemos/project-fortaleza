package org.cabradati.projectfortaleza.modules.village.models

import com.fasterxml.jackson.annotation.JsonIgnore
import java.util.UUID

class Village(
    var name: String,
    @JsonIgnore val villagers: List<Villager> = emptyList<Villager>(),
    val uuid: String = UUID.randomUUID().toString(),
)
