package com.atlanta.project.entity

import com.atlanta.project.utils.PermissionSet
import com.atlanta.project.utils.Snowflake
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RestGuild(
    @SerialName("id") val id: Snowflake,
    @SerialName("name") val name: String,
    @SerialName("icon") val icon: String?,
    @SerialName("splash") val splash: String?,
    @SerialName("discovery_splash") val discoverySplash: String?,
    @SerialName("owner_id") val ownerId: Snowflake,
    @SerialName("owner") val isOwner: Boolean? = null,
    @SerialName("permissions") val permissions: PermissionSet,
)