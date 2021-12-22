package com.atlanta.project.entity

import com.atlanta.project.utils.PermissionSet
import com.atlanta.project.utils.Snowflake
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RestGuild(
    val id: Snowflake,
    val name: String,
    val icon: String?,
    val splash: String?,
    @SerialName("discovery_splash") val discoverySplash: String?,
    @SerialName("owner_id") val ownerId: Snowflake,
    @SerialName("owner") val isOwner: Boolean? = null,
    val permissions: PermissionSet,
)