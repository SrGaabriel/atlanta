package com.atlanta.project.entity

import com.atlanta.project.utils.PermissionSet
import com.atlanta.project.utils.Snowflake
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RestRole(
    @SerialName("id") val id: Snowflake,
    @SerialName("name") val name: String,
    @SerialName("color") val color: Int,
    @SerialName("hoist") val hoist: Boolean,
    @SerialName("position") val position: Int,
    @SerialName("permissions") val permissions: PermissionSet,
    @SerialName("managed") val managed: Boolean,
    @SerialName("mentionable") val mentionable: Boolean
) { @SerialName("permissions_new") val permissionsText: String = permissions.bitMask.toString() }