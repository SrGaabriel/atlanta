package com.atlanta.project.rest.response

import com.atlanta.project.rest.PermissionSet
import com.atlanta.project.rest.Snowflake
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