package com.atlanta.project.entity

import com.atlanta.project.utils.Snowflake
import com.atlanta.project.utils.Timestamp
import kotlinx.serialization.Contextual
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@Serializable
data class RestMessage(
    @SerialName("id") val id: Snowflake,
    @SerialName("channel_id") val channelId: Snowflake,
    @SerialName("guild_id") val guildId: Snowflake? = null,
    @SerialName("author") val author: RestUser,
    @SerialName("member") val member: RestMember? = null,
    @SerialName("content") val content: String? = null,
    @SerialName("timestamp") val timestamp: Timestamp,
    @SerialName("edited_timestamp") val editTime: Timestamp,
    @SerialName("tts") val tts: Boolean,
    @SerialName("mention_everyone") val mentionsEveryone: Boolean,
    @SerialName("mentions") val mentions: List<RestUser>,
    @SerialName("mention_roles") val mentionRoles: List<Snowflake>,
    @SerialName("mention_channels") val mentionChannels: List<RestChannel>,
    @SerialName("attachments") val attachments: List<RestAttachment>,
    @SerialName("embeds") val embeds: List<RestMessageEmbed>,
    @SerialName("reactions") val reactions: List<RestReaction>,
    @SerialName("nonce") @Contextual val nonce: Any? = null,
    @SerialName("pinned") val pinned: Boolean,
    @SerialName("webhook_id") val webhookId: Snowflake? = null,
    @SerialName("type") val type: RestMessageType,
    @SerialName("activity") val activity: RestActivity? = null,
    @SerialName("application") val application: RestMessageApplication,
    @SerialName("message_reference") val reference: RestMessageReference,
    @SerialName("flags") val flags: List<RestMessageFlag>? = null
)

@Serializable
data class RestMessageEmbed(
    @SerialName("title") val title: String? = null,
    @SerialName("type") val type: String? = null,
    @SerialName("description") val description: String? = null,
    @SerialName("url") val url: String? = null,
    @SerialName("timestamp") val timestamp: Timestamp? = null,
    @SerialName("color") val color: Int? = null,
    @SerialName("footer") val footer: RestEmbedFooter? = null,
    @SerialName("image") val image: RestEmbedImage? = null,
    @SerialName("thumbnail") val thumbnail: RestEmbedImage? = null,
    @SerialName("video") val video: RestEmbedVideo? = null,
    @SerialName("provider") val provider: RestEmbedProvider? = null,
    @SerialName("author") val author: RestEmbedAuthor? = null,
    @SerialName("fields") val fields: List<RestEmbedField>? = null
)

@Serializable
data class RestMessageReference(
    @SerialName("message_id") val messageId: Snowflake? = null,
    @SerialName("channel_id") val channelId: Snowflake,
    @SerialName("guild_id") val guildId: Snowflake? = null
)

@Serializable
enum class RestMessageFlag(val bitMask: Int) {

    CROSSPOSTED(1 shl 0),

    IS_CROSSPOSTED(1 shl 1),

    SUPPRESS_EMBEDS(1 shl 2),

    SOURCE_MESSAGE_DELETED(1 shl 3),

    URGENT(1 shl 4)

}

@Serializable(with = RestMessageTypeSerializer::class)
enum class RestMessageType(val id: Int) {

    DEFAULT(0),

    RECIPIENT_ADD(1),

    RECIPIENT_REMOVE(2),

    CALL(3),

    CHANNEL_NAME_CHANGE(4),

    CHANNEL_ICON_CHANGE(5),

    CHANNEL_PINNED_MESSAGE(6),

    GUILD_MEMBER_JOIN(7),

    USER_PREMIUM_GUILD_SUBSCRIPTION(8),

    USER_PREMIUM_GUILD_SUBSCRIPTION_TIER_1(9),

    USER_PREMIUM_GUILD_SUBSCRIPTION_TIER_2(10),

    USER_PREMIUM_GUILD_SUBSCRIPTION_TIER_3(11),

    CHANNEL_FOLLOW_ADD(12),

    GUILD_DISCOVERY_DISQUALIFIED(14),

    GUILD_DISCOVERY_REQUALIFIED(15);

}

@Serializable
data class RestEmbedAuthor(
    @SerialName("name") val name: String? = null,
    @SerialName("url") val url: String? = null,
    @SerialName("icon_url") val iconUrl: String? = null,
    @SerialName("proxy_icon_url") val proxyUrl: String? = null
)

@Serializable
data class RestEmbedProvider(
    @SerialName("name") val name: String? = null,
    @SerialName("url") val url: String? = null
)


@Serializable
data class RestEmbedVideo(
    @SerialName("url") val url: String? = null,
    @SerialName("height") val height: Int? = null,
    @SerialName("width") val width: Int? = null
)

@Serializable
data class RestEmbedField(
    @SerialName("name") val name: String,
    @SerialName("value") val value: String,
    @SerialName("inline") val inline: Boolean
)

@Serializable
data class RestEmbedImage(
    @SerialName("url") val url: String? = null,
    @SerialName("proxy_url") val proxyUrl: String? = null,
    @SerialName("height") val height: Int? = null,
    @SerialName("width") val width: Int? = null
)

@Serializable
data class RestEmbedFooter(
    @SerialName("text") val text: String,
    @SerialName("icon_url") val iconUrl: String,
    @SerialName("proxy_icon_url") val proxyUrl: String
)

object RestMessageFlagSerializer: KSerializer<RestMessageFlag> {

    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("type", PrimitiveKind.INT)

    override fun deserialize(decoder: Decoder): RestMessageFlag = RestMessageFlag.values().first { it.bitMask == decoder.decodeInt() }

    override fun serialize(encoder: Encoder, value: RestMessageFlag) = encoder.encodeInt(value.bitMask)


}

object RestMessageTypeSerializer: KSerializer<RestMessageType> {

    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("type", PrimitiveKind.INT)

    override fun deserialize(decoder: Decoder): RestMessageType = RestMessageType.values().first { it.id == decoder.decodeInt() }

    override fun serialize(encoder: Encoder, value: RestMessageType) = encoder.encodeInt(value.id)

}