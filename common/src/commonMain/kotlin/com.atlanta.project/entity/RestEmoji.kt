package com.atlanta.project.entity

import com.atlanta.project.utils.Snowflake
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RestEmoji(
    val id: Snowflake?,
    val name: String?,
    val roles: List<RestRole>? = null,
    @SerialName("user") val creator: RestUser? = null,
    @SerialName("require_colons") val colons: Boolean? = null,
    val managed: Boolean? = null,
    val animated: Boolean? = null,
    val available: Boolean? = null
)