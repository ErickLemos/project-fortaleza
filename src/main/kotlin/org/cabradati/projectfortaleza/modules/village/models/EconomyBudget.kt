package org.cabradati.projectfortaleza.modules.village.models

import java.math.BigInteger

class EconomyBudget(
    var wood: BigInteger = BigInteger.ZERO,
    var iron: BigInteger = BigInteger.ZERO,
) {
    companion object {
        val EMPTY = EconomyBudget(
            wood = BigInteger.ZERO,
            iron = BigInteger.ZERO
        )
    }
}