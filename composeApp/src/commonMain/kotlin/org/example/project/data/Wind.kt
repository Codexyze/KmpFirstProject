package org.example.project.data
import kotlinx.serialization.Serializable


@Serializable
data class Wind(
    val deg: Int?=null,
    val speed: Double?=null
)