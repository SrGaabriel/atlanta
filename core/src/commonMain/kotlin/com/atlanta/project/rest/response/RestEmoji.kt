package com.atlanta.project.rest.response

import com.atlanta.project.rest.Snowflake
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RestEmoji(
    @SerialName("id") val id: Snowflake?,
    @SerialName("name") val name: String?,
    @SerialName("roles") val roles: List<RestRole>? = null,
    @SerialName("user") val creator: RestUser? = null,
    @SerialName("require_colons") val colons: Boolean? = null,
    @SerialName("managed") val managed: Boolean? = null,
    @SerialName("animated") val animated: Boolean? = null,
    @SerialName("available") val available: Boolean? = null
)