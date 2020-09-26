package com.atlanta.project.rest.response

import kotlinx.serialization.*
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

import com.atlanta.project.rest.PermissionSet

@Serializable
data class ResponseChannel(
    @SerialName("id") val id: Long,
    @SerialName("type") val type: Int,
    @SerialName("guild_id") val guildId: Long? = null,
    @SerialName("position") val position: Int? = null,
    @SerialName("permission_overwrites") val permissions: PermissionSet = PermissionSet(0x00000000),
    @SerialName("name") val name: String? = "",
    @SerialName("topic") val topic: String? = null,
    @SerialName("last_message_id") val lastMessage: Long? = null,
    @SerialName("bitrate") val bitRate: Int? = null,
    @SerialName("user_limit") val userLimit: Int? = null,
    @SerialName("rate_limit_per_user") val rateLimitPerUser: Int? = null,
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

