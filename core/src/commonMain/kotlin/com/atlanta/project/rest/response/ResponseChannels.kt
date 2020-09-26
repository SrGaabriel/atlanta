package com.atlanta.project.rest.response

import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

import com.atlanta.project.rest.PermissionSet
import com.atlanta.project.rest.Snowflake
import kotlinx.serialization.KSerializer

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseChannel(
    @SerialName("id") val id: Snowflake,
    @SerialName("type") val type: ResponseChannelEntityType,
    @SerialName("guild_id") val guildId: Snowflake? = null,
    @SerialName("position") val position: Int? = null,
    @SerialName("permission_overwrites") val permissions: Array<ResponsePermissionOverwrite>? = null,
    @SerialName("name") val name: String? = null,
    @SerialName("topic") val topic: String? = null,
    @SerialName("nsfw") val nsfw: Boolean? = null,
    @SerialName("last_message_id") val lastMessage: Snowflake? = null,
    @SerialName("bitrate") val bitRate: Int? = null,
    @SerialName("user_limit") val userLimit: Int? = null,
    @SerialName("rate_limit_per_user") val rateLimitPerUser: Int? = null,
    @SerialName("recipients") val recipients: List<ResponseUser>? = null,
    @SerialName("icon") val icon: String? = null,
    @SerialName("owner_id") val ownerId: Snowflake? = null,
    @SerialName("application_id") val applicationId: Snowflake? = null,
    @SerialName("parent_id") val parentId: Snowflake? = null,
    @SerialName("last_pin_timestamp") val lastPinTimestamp: Long? = null
)

@Serializable(with = ResponseChannelEntityTypeSerializer::class)
enum class ResponseChannelEntityType(internal val id: Int) {

    GUILD_TEXT(0),

    PERSONAL_TEXT(1),

    GUILD_VOICE(2),

    PERSONAL_GROUP(3),

    GUILD_CATEGORY(4),

    GUILD_NEWS(5),

    GUILD_STORE(6)

}

object ResponseChannelEntityTypeSerializer: KSerializer<ResponseChannelEntityType> {

    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("type", PrimitiveKind.INT)

    override fun deserialize(decoder: Decoder): ResponseChannelEntityType = ResponseChannelEntityType.values().first { it.id == decoder.decodeInt() }

    override fun serialize(encoder: Encoder, value: ResponseChannelEntityType) = encoder.encodeInt(value.id)

}

@Serializable
data class ResponsePermissionOverwrite(
    @SerialName("id") val id: Long,
    @SerialName("type") val type: String,
    @SerialName("allow_new") val allowed: PermissionSet,
    @SerialName("deny_new") val denied: PermissionSet
)

