package com.atlanta.project.rest.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RestReaction(
    @SerialName("count") val count: Int,
    @SerialName("me") val self: Boolean,
    @SerialName("emoji") val emoji: RestEmoji
)