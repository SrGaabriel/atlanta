package com.atlanta.project.entity

import com.atlanta.project.utils.PermissionSet
import com.atlanta.project.utils.Snowflake
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

import kotlinx.serialization.KSerializer

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RestChannel(
    @SerialName("id") val id: Snowflake,
    @SerialName("type") val type: RestChannelEntityType,
    @SerialName("guild_id") val guildId: Snowflake? = null,
    @SerialName("position") val position: Int? = null,
    @SerialName("permission_overwrites") val permissions: List<RestPermissionOverwrite>? = null,
    @SerialName("name") val name: String? = null,
    @SerialName("topic") val topic: String? = null,
    @SerialName("nsfw") val nsfw: Boolean? = null,
    @SerialName("last_message_id") val lastMessage: Snowflake? = null,
    @SerialName("bitrate") val bitRate: Int? = null,
    @SerialName("user_limit") val userLimit: Int? = null,
    @SerialName("rate_limit_per_user") val rateLimitPerUser: Int? = null,
    @SerialName("recipients") val recipients: List<RestUser>? = null,
    @SerialName("icon") val icon: String? = null,
    @SerialName("owner_id") val ownerId: Snowflake? = null,
    @SerialName("application_id") val applicationId: Snowflake? = null,
    @SerialName("parent_id") val parentId: Snowflake? = null,
    @SerialName("last_pin_timestamp") val lastPinTimestamp: Long? = null
)

@Serializable(with = RestChannelEntityTypeSerializer::class)
enum class RestChannelEntityType(internal val id: Int) {

    GUILD_TEXT(0),

    PERSONAL_TEXT(1),

    GUILD_VOICE(2),

    PERSONAL_GROUP(3),

    GUILD_CATEGORY(4),

    GUILD_NEWS(5),

    GUILD_STORE(6)

}

object RestChannelEntityTypeSerializer: KSerializer<RestChannelEntityType> {

    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("type", PrimitiveKind.INT)

    override fun deserialize(decoder: Decoder): RestChannelEntityType = RestChannelEntityType.values().first { it.id == decoder.decodeInt() }

    override fun serialize(encoder: Encoder, value: RestChannelEntityType) = encoder.encodeInt(value.id)

}

@Serializable
data class RestPermissionOverwrite(
    @SerialName("id") val id: Long,
    @SerialName("type") val type: String,
    @SerialName("allow") val allowed: PermissionSet,
    @SerialName("deny") val denied: PermissionSet
)