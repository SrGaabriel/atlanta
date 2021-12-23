package com.atlanta.project.entity

import com.atlanta.project.utils.PermissionSet
import com.atlanta.project.utils.Snowflake
import com.atlanta.project.utils.Timestamp
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RestMember(
    val user: RestUser? = null,
    @SerialName("nick") val nickname: String?,
    val avatar: String? = null,
    val roles: List<Snowflake>,
    @SerialName("joined_at") val joinedAt: Timestamp,
    @SerialName("premium_since") val premiumSince: Timestamp? = null,
    val deaf: Boolean,
    val mute: Boolean,
    val pending: Boolean? = null,
    val permissions: PermissionSet,
    @SerialName("communication_disabled_until") val timeoutExpirationTime: Timestamp
)