package org.cabradati.projectfortaleza.modules.relationship

import org.cabradati.projectfortaleza.core.models.Village
import org.cabradati.projectfortaleza.modules.Module
import org.jgrapht.graph.DefaultDirectedGraph
import org.jgrapht.graph.DefaultEdge

object RelationshipModule: Module {
    private val datasource = DefaultDirectedGraph<Village, DefaultEdge>(DefaultEdge::class.java)

    override fun init() {
        bootLoad()
    }

    private fun bootLoad() {
        println("loading data source")
    }

    fun registerVillage(village: Village) {
        datasource.addVertex(village)
        println(datasource.toString())
    }

}