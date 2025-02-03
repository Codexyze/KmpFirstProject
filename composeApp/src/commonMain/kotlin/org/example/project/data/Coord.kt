package org.example.project.data

import kotlinx.serialization.Serializable


@Serializable
data class Coord(
    val lat: Double?=null,
    val lon: Double?=null
)