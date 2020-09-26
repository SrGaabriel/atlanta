package com.atlanta.project.rest.response

import com.atlanta.project.rest.PermissionSet
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@Serializable
data class ResponseChannel(
    @SerialName("id") val id: Long,
    @SerialName("type") val type: Int,
    @SerialName("guild_id") val guildId: Long,
    @SerialName("position") val position: Int,
    @SerialName("name") val name: String,
) {

    fun getType(): ResponseChannelEntityType = ResponseChannelEntityType.values().first {
        it.id == type
    }

}

@Serializable
enum class ResponseChannelEntityType(internal val id: Int) {

    GUILD_TEXT(0),

    PERSONAL_TEXT(1),

    GUILD_VOICE(2),

    PERSONAL_GROUP(3),

    GUILD_CATEGORY(4),

    GUILD_NEWS(5),

    GUILD_STORE(6)

}

class ResponseChannelEntityTypeSerializer: KSerializer<ResponseChannelEntityType> {

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

