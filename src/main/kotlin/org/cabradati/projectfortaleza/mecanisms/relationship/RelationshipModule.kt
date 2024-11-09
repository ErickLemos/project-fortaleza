package org.cabradati.projectfortaleza.mecanisms.relationship

import org.cabradati.projectfortaleza.core.models.Village
import org.jgrapht.graph.DefaultDirectedGraph
import org.jgrapht.graph.DefaultEdge

object RelationshipModule {
    private val datasource = DefaultDirectedGraph<Village, DefaultEdge>(DefaultEdge::class.java)

    fun init() {
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