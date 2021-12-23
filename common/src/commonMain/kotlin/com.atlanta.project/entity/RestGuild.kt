package com.atlanta.project.entity

import com.atlanta.project.utils.*
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@Serializable
data class RestGuild(
    val id: Snowflake,
    val name: String,
    val icon: String?,
    @SerialName("icon_hash") val iconHash: String?,
    val splash: String?,
    @SerialName("discovery_splash") val discoverySplash: String?,
    @SerialName("owner") val isOwner: Boolean? = null,
    @SerialName("owner_id") val ownerId: Snowflake,
    val permissions: PermissionSet,
    val region: String? = null,
    @SerialName("afk_channel_id") val afkChannelId: Snowflake? = null,
    @SerialName("afk_timeout") val afkTimeout: Int,
    @SerialName("widget_enabled") val widgetEnabled: Boolean? = null,
    @SerialName("widget_channel_id") val widgetChannelId: Snowflake? = null,
    @SerialName("verification_level") val verificationLevel: Int,
    @SerialName("default_message_notifications") val defaultMessageNotifications: Int,
    @SerialName("explicit_content_filter") val explicitContentFilter: Int,
    val roles: List<RestRole> = emptyList(),
    val emojis: List<RestEmoji> = emptyList(),
    val features: List<RestGuildFeature> = emptyList(),
    @SerialName("mfa_level") val mfaLevel: Int,
    @SerialName("application_id") val applicationId: Snowflake? = null,
    @SerialName("system_channel_id") val systemChannelId: Snowflake? = null,
    @SerialName("system_channel_flags") val systemChannelFlags: RestSystemChannelFlag,
    @SerialName("rules_channel_id") val rulesChannelId: Snowflake? = null,
    @SerialName("joined_at") val joinedAt: Timestamp,
    val large: Boolean? = null,
    val unavailable: Boolean? = null,
    @SerialName("member_count") val memberCount: Int? = null,
    @SerialName("voice_states") val voiceStates: List<RestUserGuildVoiceState> = emptyList(),
    val members: List<RestMember> = emptyList(),
    val channels: List<RestChannel> = emptyList(),
    val threads: List<RestChannel> = emptyList(),
    val presences: List<RestUserGuildPresenceUpdate> = emptyList(),
    @SerialName("max_presences") val maxPresences: Int? = null,
    @SerialName("max_members") val maxMembers: Int? = null,
    @SerialName("vanity_url_code") val vanityUrlCode: String,
    val description: String? = null,
    val banner: String? = null,
    @SerialName("premium_tier") val premiumTier: RestGuildPremiumTier,
    @SerialName("premium_subscription_count") val boostCount: Int? = null,
    @SerialName("preferred_locale") val locale: String,
    @SerialName("public_updates_channel_id") val publicUpdatesChannelId: Snowflake? = null,
    @SerialName("max_video_channel_users") val maxVideoChannelUsers: Int? = null,
    @SerialName("approximate_member_count") val approximateMemberCount: Int? = null,
    @SerialName("approximate_presence_count") val approximatePresenceCount: Int? = null,
    @SerialName("welcome_screen") val welcomeScreen: RestGuildWelcomeScreen,
    @SerialName("nsfw_level") val nsfwLevel: RestGuildNsfwLevel,
    @SerialName("stage_instances") val stageInstance: List<RestGuildStageInstance> = emptyList(),
    val stickers: List<RestSticker> = emptyList(),
    @SerialName("guild_scheduled_events") val guildScheduledEvents: List<RestGuildScheduledEvent>,
    @SerialName("premium_progress_bar_enabled") val premiumProgressBarEnabled: Boolean
)

@Serializable
data class RestUserGuildVoiceState(
    @SerialName("guild_id") val guildId: Snowflake? = null,
    @SerialName("channel_id") val channelId: Snowflake?,
    @SerialName("user_id") val userId: Snowflake,
    val member: RestMember? = null,
    @SerialName("session_id") val sessionId: String,
    val deaf: Boolean,
    val mute: Boolean,
    @SerialName("self_deaf") val selfDeaf: Boolean,
    @SerialName("self_mute") val selfMute: Boolean,
    @SerialName("self_stream") val selfStream: Boolean? = null,
    @SerialName("self_video") val selfVideo: Boolean,
    val suppress: Boolean,
    @SerialName("request_to_speak_timestamp") val requestToSpeakTimestamp: Timestamp?
)

@Serializable
data class RestUserGuildPresenceUpdate(
    val user: RestUser,
    @SerialName("guild_id") val guildId: Snowflake,
    val status: String,
    val activities: List<RestActivity>,
    @SerialName("client_status") val clientStatus: RestClientStatus
)

@Serializable
data class RestGuildWelcomeScreen(
    val description: String?,
    @SerialName("welcome_channels") val welcomeChannels: List<RestGuildWelcomeScreenChannel> = emptyList()
)

@Serializable
data class RestGuildWelcomeScreenChannel(
    @SerialName("channel_id") val channelId: Snowflake,
    val description: String,
    @SerialName("emoji_id") val emojiId: Snowflake? = null,
    @SerialName("emoji_name") val emojiName: String? = null
)

@Serializable
data class RestGuildStageInstance(
    val id: Snowflake,
    @SerialName("guild_id") val guildId: Snowflake?,
    @SerialName("channel_id") val channelId: Snowflake?,
    val topic: String,
    @SerialName("privacy_level") val privacyLevel: Int,
    val discoverableDisabled: Boolean
)

@Serializable
data class RestGuildScheduledEvent(
    val id: Snowflake,
    @SerialName("guild_id") val guildId: Snowflake,
    @SerialName("channel_id") val channelId: Snowflake?,
    @SerialName("creator_id") val creatorId: Snowflake?,
    val name: String,
    val description: String? = null,
    @SerialName("scheduled_start_time") val scheduledStartTime: Timestamp,
    @SerialName("scheduled_end_time") val scheduledEndTime: Timestamp?,
    @SerialName("privacy_level") val privacyLevel: Int,
    val status: RestGuildScheduledEventStatus,
    @SerialName("entity_type") val entityType: RestGuildScheduledEventEntityType,
    @SerialName("entity_id") val entityId: Snowflake? = null,
    @SerialName("entity_metadata") val entityMetadata: RestGuildScheduledEventEntityMetadata? = null,
    val creator: RestUser? = null,
    @SerialName("user_count") val userCount: Int? = null
)

@Serializable
data class RestGuildScheduledEventEntityMetadata(
    val location: String? = null
)

@Serializable(RestGuildFeatureSerializer::class)
enum class RestGuildFeature {
    ANIMATED_ICON,
    BANNER,
    COMMERCE,
    COMMUNITY,
    DISCOVERABLE,
    FEATURABLE,
    INVITE_SPLASH,
    MEMBER_VERIFICATION_GATE_ENABLED,
    MONETIZATION_ENABLED,
    MORE_STICKERS,
    NEWS,
    PARTNERED,
    PREVIEW_ENABLED,
    PRIVATE_THREADS,
    ROLE_ICONS,
    SEVEN_DAY_THREAD_ARCHIVE,
    THREE_DAY_THREAD_ARCHIVE,
    TICKETED_EVENTS_ENABLED,
    VANITY_URL,
    VERIFIED,
    VIP_REGIONS,
    WELCOME_SCREEN_ENABLED
}

enum class RestSystemChannelFlag(val bits: Int) {

    SUPPRESS_JOIN_NOTIFICATIONS(1 shl 0),

    SUPPRESS_PREMIUM_SUBSCRIPTIONS(1 shl 1),

    SUPPRESS_GUILD_REMINDER_NOTIFICATIONS(1 shl 2),

    SUPPRESS_JOIN_NOTIFICATION_REPLIES(1 shl 3);

}

@Serializable(with = RestSystemChannelFlagSet.Serializer::class)
data class RestSystemChannelFlagSet(override val bitMask: Int): BitmaskHolder<RestSystemChannelFlagSet> {

    operator fun plus(value: RestActivityFlagSet): RestSystemChannelFlagSet = RestSystemChannelFlagSet(bitMask or value.bitMask)

    operator fun minus(value: RestActivityFlagSet) = RestActivityFlagSet(bitMask and value.bitMask.inv())

    companion object Serializer: BitmaskSerializer<RestSystemChannelFlagSet>({bitmask -> RestSystemChannelFlagSet(bitmask)})
}

@Serializable(RestGuildPremiumTierSerializer::class)
enum class RestGuildPremiumTier(val value: Int) {
    NONE(0),
    TIER_1(1),
    TIER_2(2),
    TIER_3(3);

    companion object: DefaultIntIdEnumSerializationStrategy<RestGuildPremiumTier>(values().associateBy { it.value })
}
object RestGuildPremiumTierSerializer: IntIdSerializer<RestGuildPremiumTier>(RestGuildPremiumTier::class, RestGuildPremiumTier)

@Serializable(RestGuildNsfwLevelSerializer::class)
enum class RestGuildNsfwLevel(val value: Int) {
    DEFAULT(0),
    EXPLICIT(1),
    SAFE(2),
    AGE_RESTRICTED(3);

    companion object: DefaultIntIdEnumSerializationStrategy<RestGuildNsfwLevel>(values().associateBy { it.value })
}
object RestGuildNsfwLevelSerializer: IntIdSerializer<RestGuildNsfwLevel>(RestGuildNsfwLevel::class, RestGuildNsfwLevel)

@Serializable(RestGuildScheduledEventStatusSerializer::class)
enum class RestGuildScheduledEventStatus(val value: Int) {
    SCHEDULED(1),
    ACTIVE(2),
    COMPLETED(3),
    CANCELED(4);

    companion object: DefaultIntIdEnumSerializationStrategy<RestGuildScheduledEventStatus>(values().associateBy { it.value })
}
object RestGuildScheduledEventStatusSerializer: IntIdSerializer<RestGuildScheduledEventStatus>(RestGuildScheduledEventStatus::class, RestGuildScheduledEventStatus)

@Serializable(RestGuildScheduledEventEntityTypeSerializer::class)
enum class RestGuildScheduledEventEntityType(val value: Int) {
    STAGE_INSTANCE(1),
    VOICE(2),
    EXTERNAL(3);

    companion object: DefaultIntIdEnumSerializationStrategy<RestGuildScheduledEventEntityType>(values().associateBy { it.value })
}
object RestGuildScheduledEventEntityTypeSerializer: IntIdSerializer<RestGuildScheduledEventEntityType>(RestGuildScheduledEventEntityType::class, RestGuildScheduledEventEntityType)

object RestGuildFeatureSerializer: KSerializer<RestGuildFeature> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("RestGuildFeatureSerializer", PrimitiveKind.STRING)

    override fun deserialize(decoder: Decoder): RestGuildFeature = RestGuildFeature.valueOf(decoder.decodeString())

    override fun serialize(encoder: Encoder, value: RestGuildFeature) = encoder.encodeString(value.toString())
}