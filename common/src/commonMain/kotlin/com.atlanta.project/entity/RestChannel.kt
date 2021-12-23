package com.atlanta.project.entity

import com.atlanta.project.utils.DefaultIntIdEnumSerializationStrategy
import com.atlanta.project.utils.IntIdSerializer
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
    @SerialName("permission_overwrites") val permissionsOverwrites: List<RestPermissionOverwrite>? = null,
    val name: String? = null,
    val topic: String? = null,
    val nsfw: Boolean? = null,
    @SerialName("bitrate") val bitRate: Int? = null,
    @SerialName("last_message_id") val lastMessage: Snowflake? = null,
    @SerialName("user_limit") val userLimit: Int? = null,
    @SerialName("rate_limit_per_user") val rateLimitPerUser: Int? = null,
    val recipients: List<RestUser>? = null,
    val icon: String? = null,
    @SerialName("owner_id") val ownerId: Snowflake? = null,
    @SerialName("application_id") val applicationId: Snowflake? = null,
    @SerialName("parent_id") val parentId: Snowflake? = null,
    @SerialName("last_pin_timestamp") val lastPinTimestamp: Long? = null,
    @SerialName("rtc_region") val rtcRegion: String? = null,
    @SerialName("video_quality_mode") val videoQualityMode: Int? = null,
    @SerialName("message_count") val messageCount: Int? = null,
    @SerialName("member_count") val memberCount: Int? = null,
    @SerialName("thread_metadata") val threadMetadata: RestThreadMetadata? = null,
    val member: RestThreadMember? = null,
    @SerialName("default_auto_archive_duration") val defaultAutoArchiveDuration: Int? = null,
    @SerialName("permissions") val slashCommandsPermissionSet: PermissionSet? = null
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

    GUILD_STAGE_VOICE(13);

    companion object: DefaultIntIdEnumSerializationStrategy<RestChannelEntityType>(values().associateBy { it.id })
}
object RestChannelEntityTypeSerializer: IntIdSerializer<RestChannelEntityType>(RestChannelEntityType::class, RestChannelEntityType)

@Serializable
data class RestPermissionOverwrite(
    val id: Long,
    val type: String,
    val allowed: PermissionSet,
    val denied: PermissionSet
)