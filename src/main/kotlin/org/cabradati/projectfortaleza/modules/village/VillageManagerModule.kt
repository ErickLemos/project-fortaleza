package org.cabradati.projectfortaleza.modules.village

import org.cabradati.projectfortaleza.core.interfaces.InitModule
import org.cabradati.projectfortaleza.modules.village.event.VillageCreationEvent

object VillageManagerModule : InitModule {

    override fun init() {
        VillageCreationEvent.register()
    }
}