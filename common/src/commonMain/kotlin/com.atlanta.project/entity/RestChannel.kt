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
    val id: Snowflake,
    val type: RestChannelEntityType,
    @SerialName("guild_id") val guildId: Snowflake? = null,
    val position: Int? = null,
    @SerialName("permission_overwrites") val permissions: List<RestPermissionOverwrite>? = null,
    val name: String? = null,
    val topic: String? = null,
    val nsfw: Boolean? = null,
    @SerialName("last_message_id") val lastMessage: Snowflake? = null,
    @SerialName("bitrate") val bitRate: Int? = null,
    @SerialName("user_limit") val userLimit: Int? = null,
    @SerialName("rate_limit_per_user") val slowmode: Int? = null,
    val recipients: List<RestUser>? = null,
    val icon: String? = null,
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

    GUILD_STORE(6),

    GUILD_NEWS_THREAD(10),

    GUILD_PUBLIC_THREAD(10),

    GUILD_PRIVATE_THREAD(12),

    GUILD_STAGE_VOICE(13)

}

object RestChannelEntityTypeSerializer: KSerializer<RestChannelEntityType> {

    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("type", PrimitiveKind.INT)

    override fun deserialize(decoder: Decoder): RestChannelEntityType = RestChannelEntityType.values().first { it.id == decoder.decodeInt() }

    override fun serialize(encoder: Encoder, value: RestChannelEntityType) = encoder.encodeInt(value.id)

}

@Serializable
data class RestPermissionOverwrite(
    val id: Long,
    val type: String,
    val allowed: PermissionSet,
    val denied: PermissionSet
)