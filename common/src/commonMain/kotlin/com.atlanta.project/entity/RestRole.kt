package com.atlanta.project.entity

import com.atlanta.project.utils.PermissionSet
import com.atlanta.project.utils.Snowflake
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RestRole(
    val id: Snowflake,
    val name: String,
    val color: Int,
    val hoist: Boolean,
    val position: Int,
    val permissions: PermissionSet,
    val managed: Boolean,
    val mentionable: Boolean
) { @SerialName("permissions_new") val permissionsText: String = permissions.bitMask.toString() }