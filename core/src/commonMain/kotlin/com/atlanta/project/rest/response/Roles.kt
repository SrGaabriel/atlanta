package com.atlanta.project.rest.response

import com.atlanta.project.rest.PermissionSet
import com.atlanta.project.rest.Snowflake
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseRole(
    @SerialName("id") val id: Snowflake,
    @SerialName("name") val name: String,
    @SerialName("color") val color: Int,
    @SerialName("hoist") val hoist: Boolean,
    @SerialName("position") val position: Int,
    @SerialName("permissions") val permissions: PermissionSet,
    @SerialName("managed") val managed: Boolean,
    @SerialName("mentionable") val mentionable: Boolean
) { @SerialName("permissions_new") val permissionsText: String = permissions.bitMask.toString() }