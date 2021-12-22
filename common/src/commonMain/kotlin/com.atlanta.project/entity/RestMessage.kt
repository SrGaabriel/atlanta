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
    val id: Snowflake,
    @SerialName("channel_id") val channelId: Snowflake,
    @SerialName("guild_id") val guildId: Snowflake? = null,
    val author: RestUser,
    val member: RestMember? = null,
    val content: String? = null,
    val timestamp: Timestamp,
    @SerialName("edited_timestamp") val editTime: Timestamp,
     val tts: Boolean,
    @SerialName("mention_everyone") val mentionsEveryone: Boolean,
    val mentions: List<RestUser>,
    @SerialName("mention_roles") val mentionRoles: List<Snowflake>,
    @SerialName("mention_channels") val mentionChannels: List<RestChannel>,
    val attachments: List<RestAttachment>,
    val embeds: List<RestMessageEmbed>,
    val reactions: List<RestReaction>,
    @Contextual val nonce: Any? = null,
    val pinned: Boolean,
    @SerialName("webhook_id") val webhookId: Snowflake? = null,
    val type: RestMessageType,
    val activity: RestActivity? = null,
    val application: RestMessageApplication,
    @SerialName("message_reference") val reference: RestMessageReference,
    val flags: List<RestMessageFlag>? = null
)

@Serializable
data class RestMessageComponent(
    val type: RestMessageComponentType,
    @SerialName("custom_id") val customId: String? = null,
    val disabled: Boolean? = false,
    val style: Int?,
    val label: String?,
    val emoji: RestEmoji?,
    val url: String?,
    val options: List<RestMessageSelectOption>? = null,
    val placeholder: String?,
    val minimumValues: Int?,
    val maximumValues: Int?,
    val children: List<RestMessageComponent> = emptyList()
)

@Serializable
data class RestMessageEmbed(
    val title: String? = null,
    val type: String? = null,
    val description: String? = null,
    val url: String? = null,
    val timestamp: Timestamp? = null,
    val color: Int? = null,
    val footer: RestEmbedFooter? = null,
    val image: RestEmbedImage? = null,
    val thumbnail: RestEmbedImage? = null,
    val video: RestEmbedVideo? = null,
    val provider: RestEmbedProvider? = null,
    val author: RestEmbedAuthor? = null,
    val fields: List<RestEmbedField>? = null
)

@Serializable
data class RestMessageReference(
    @SerialName("message_id") val messageId: Snowflake? = null,
    @SerialName("channel_id") val channelId: Snowflake,
    @SerialName("guild_id") val guildId: Snowflake? = null
)

@Serializable
data class RestMessageAllowedMentions(
    val parse: List<RestAllowedMentionsType>,
    val roles: List<Snowflake> = emptyList(),
    val users: List<RestUser> = emptyList(),
    val repliedUser: Boolean
)

@Serializable
data class RestMessageSelectOption(
    val label: String,
    val value: String,
    val description: String?,
    val emoji: RestEmoji?,
    val default: Boolean?
)

@Serializable(RestMessageFlagSerializer::class)
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

@Serializable(RestMessageComponentTypeSerializer::class)
enum class RestMessageComponentType(val id: Int) {

    ACTION_ROW(1),

    BUTTON(2),

    SELECT_MENU(3)

}

@Serializable(RestAllowedMentionsSerializer::class)
enum class RestAllowedMentionsType(val value: String) {

    ROLE_MENTIONS("roles"),

    USER_MENTIONS("users"),

    EVERYONE_MENTIONS("everyone")

}

@Serializable
data class RestEmbedAuthor(
    val name: String? = null,
    val url: String? = null,
    @SerialName("icon_url") val iconUrl: String? = null,
    @SerialName("proxy_icon_url") val proxyIconUrl: String? = null
)

@Serializable
data class RestEmbedProvider(
    val name: String? = null,
    val url: String? = null
)

@Serializable
data class RestEmbedVideo(
    val url: String? = null,
    val height: Int? = null,
    val width: Int? = null
)

@Serializable
data class RestEmbedField(
    val name: String,
    val value: String,
    val inline: Boolean
)

@Serializable
data class RestEmbedImage(
    val url: String? = null,
    @SerialName("proxy_url") val proxyUrl: String? = null,
    val height: Int? = null,
    val width: Int? = null
)

@Serializable
data class RestEmbedFooter(
    val text: String,
    @SerialName("icon_url") val iconUrl: String,
    @SerialName("proxy_icon_url") val proxyIconUrl: String
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

object RestMessageComponentTypeSerializer: KSerializer<RestMessageComponentType> {

    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("type", PrimitiveKind.INT)

    override fun deserialize(decoder: Decoder): RestMessageComponentType = RestMessageComponentType.values().first { it.id == decoder.decodeInt() }

    override fun serialize(encoder: Encoder, value: RestMessageComponentType) = encoder.encodeInt(value.id)

}

object RestAllowedMentionsSerializer: KSerializer<RestAllowedMentionsType> {

    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("type", PrimitiveKind.INT)

    override fun deserialize(decoder: Decoder): RestAllowedMentionsType = RestAllowedMentionsType.values().first { it.value == decoder.decodeString() }

    override fun serialize(encoder: Encoder, value: RestAllowedMentionsType) = encoder.encodeString(value.value)
}