package com.atlanta.project.rest.response

import com.atlanta.project.rest.Snowflake
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseEmoji(
    @SerialName("id") val id: Snowflake?,
    @SerialName("name") val name: String?,
    @SerialName("roles") val roles: List<ResponseRole>? = null,
    @SerialName("user") val creator: ResponseUser? = null,
    @SerialName("require_colons") val colons: Boolean? = null,
    @SerialName("managed") val managed: Boolean? = null,
    @SerialName("animated") val animated: Boolean? = null,
    @SerialName("available") val available: Boolean? = null
)


@Serializable
data class ResponseReaction(
    @SerialName("count") val count: Int,
    @SerialName("me") val self: Boolean,
    @SerialName("emoji") val emoji: ResponseEmoji
)