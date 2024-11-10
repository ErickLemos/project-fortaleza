package org.cabradati.projectfortaleza.core.models

import org.dizitart.no2.repository.annotations.Entity
import org.dizitart.no2.repository.annotations.Id
import java.util.UUID.randomUUID

@Entity
class Village(
    @Id val uuid: String = randomUUID().toString(),
    val name: String,
    val description: String,
    val budget: EconomyBudget
)