package org.cabradati.projectfortaleza.mecanisms.relationship

import org.cabradati.projectfortaleza.models.Village
import org.jgrapht.graph.DefaultDirectedGraph
import org.jgrapht.graph.DefaultEdge

object RelationshipMemoryDatasource {
    // TODO: careful for parallel computations
    private val relationship = DefaultDirectedGraph<Village, DefaultEdge>(DefaultEdge::class.java)

    fun addVillage(village: Village) {
        relationship.addVertex(village)
    }

    fun removeVillage(village: Village) {
        relationship.removeVertex(village)
    }

}