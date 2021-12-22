package com.atlanta.project.request.channel

import com.atlanta.project.entity.RestChannelEntityType
import com.atlanta.project.entity.RestPermissionOverwrite
import com.atlanta.project.utils.Snowflake
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Retention(AnnotationRetention.SOURCE)
@Target(AnnotationTarget.FIELD)
annotation class ExclusiveForChannelType(val type: RestChannelEntityType)

@Serializable
data class ModifyPrivateChannelRequest(
    val name: String?,
    val icon: String?
)

@Serializable
data class ModifyGuildChannelRequest(
    val name: String?,
    val type: RestChannelEntityType?,
    val position: Int?,
    val topic: String?,
    val nsfw: Boolean?,
    @SerialName("rate_limit_per_user") val slowMode: Int?,
    @SerialName("bitrate") val bitRate: Int?,
    @SerialName("user_limit") val userLimit: Int?,
    @SerialName("permission_overwrites") val overwrites: List<RestPermissionOverwrite>?,
    @SerialName("parent_id") val parent: Snowflake?
)

@Serializable
data class ModifyThreadChannelRequest(
    val name: String?,
    val archived: Boolean?,
    @SerialName("auto_archive_duration") val autoArchiveDuration: Int?,
    val locked: Boolean?,
    val invitable: Boolean?,
    @SerialName("rate_limit_per_user") val slowMode: Int?,
)