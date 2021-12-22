package com.atlanta.project.entity

import com.atlanta.project.utils.Snowflake
import com.atlanta.project.utils.Timestamp
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RestMember(
    @SerialName("user") val user: RestUser? = null,
    @SerialName("nick") val nick: String?,
    @SerialName("roles") val roles: List<Snowflake>,
    @SerialName("joined_at") val joinDate: Timestamp,
    @SerialName("premium_since") val premiumSince: Timestamp? = null,
    @SerialName("deaf") val deaf: Boolean,
    @SerialName("mute") val mute: Boolean
)