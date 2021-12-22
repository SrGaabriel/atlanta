package com.atlanta.project.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RestReaction(
    val count: Int,
    @SerialName("me") val self: Boolean,
    val emoji: RestEmoji
)