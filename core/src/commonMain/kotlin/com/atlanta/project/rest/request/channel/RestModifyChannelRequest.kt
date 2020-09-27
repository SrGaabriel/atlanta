package com.atlanta.project.rest.request.channel

import com.atlanta.project.rest.Snowflake
import com.atlanta.project.rest.response.RestChannelEntityType
import com.atlanta.project.rest.response.RestPermissionOverwrite
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RestModifyChannelRequest(
    @SerialName("name") val name: String,
    @SerialName("type") val type: RestChannelEntityType,
    @SerialName("position") val position: Int?,
    @SerialName("topic") val topic: String?,
    @SerialName("nsfw") val nsfw: Boolean?,
    @SerialName("rate_limit_per_user") val slowMode: Int?,
    @SerialName("bitrate") val bitRate: Int,
    @SerialName("user_limit") val userLimit: Int?,
    @SerialName("permission_overwrites") val overwrites: List<RestPermissionOverwrite>,
    @SerialName("parent_id") val parent: Snowflake
)