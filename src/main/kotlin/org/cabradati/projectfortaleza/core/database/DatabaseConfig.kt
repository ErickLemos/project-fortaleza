package org.cabradati.projectfortaleza.core.database

import org.dizitart.kno2.KNO2Module
import org.dizitart.kno2.nitrite
import org.dizitart.no2.mvstore.MVStoreModule

object DatabaseConfig {

    val db = nitrite {
        loadModule(KNO2Module())
        loadModule(MVStoreModule.withConfig()
            .filePath("config/villages/my.db")
            .build())
    }

    fun init() {
        println("initializing database: ${db.isClosed}")
    }
}