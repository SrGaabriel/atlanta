package com.atlanta.project.entity

import com.atlanta.project.utils.*
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@Serializable
data class RestActivity(
    val name: String,
    val type: RestActivityType,
    val url: String? = null,
    @SerialName("created_at") val createdAt: Long,
    val timestamps: RestActivityTimestamps? = null,
    @SerialName("application_id") val applicationId: Snowflake? = null,
    val details: String? = null,
    val state: String? = null,
    val emoji: RestEmoji? = null,
    val party: RestActivityParty? = null,
    val assets: RestActivityAssets? = null,
    val secrets: RestActivitySecrets? = null,
    val instance: Boolean? = null,
    val flags: RestActivityFlagSet? = null,
    val buttons: List<RestActivityButton> = emptyList()
)

@Serializable(RestActivityTypeSerializer::class)
enum class RestActivityType(val id: Int) {

    GAME(0),

    STREAMING(1),

    LISTENING(2),

    WATCHING(3),

    CUSTOM(4),

    COMPETING(5);

    companion object: DefaultIntIdEnumSerializationStrategy<RestActivityType>(values().associateBy { it.id })
}
object RestActivityTypeSerializer: IntIdSerializer<RestActivityType>(RestActivityType::class, RestActivityType)

enum class RestActivityFlag(val id: Int) {

    INSTANCE(1 shl 0),
    JOIN(1 shl 1),
    SPECTATE(1 shl 2),
    JOIN_REQUEST(1 shl 3),
    SYNC(1 shl 4),
    PLAY(1 shl 5),
    PARTY_PRIVACY_FRIENDS(1 shl 6),
    PARTY_PRIVACY_VOICE_CHANNEL(1 shl 7),
    EMBEDDED(1 shl 8),

}

@Serializable
data class RestActivityTimestamps(
    val start: Long? = null,
    val end: Long? = null
)

@Serializable
data class RestActivityParty(
    val id: String?,
    val size: List<Int>
) {
    @Transient val currentSize = size[0]
    @Transient val maximumSize = size[1]
}

@Serializable
data class RestActivityAssets(
    @SerialName("large_image") val largeImage: String? = null,
    @SerialName("large_text") val largeText: String? = null,
    @SerialName("small_image") val smallImage: String? = null,
    @SerialName("small_text") val smallText: String? = null,
)

@Serializable
data class RestActivitySecrets(
    val join: String? = null,
    val spectate: String? = null,
    val match: String? = null
)

@Serializable
data class RestActivityButton(
    val label: String,
    val url: String
)

@Serializable(with = RestActivityFlagSet.Serializer::class)
data class RestActivityFlagSet(override val bitMask: Int): BitmaskHolder<RestActivityFlagSet> {

    operator fun plus(value: RestActivityFlagSet): RestActivityFlagSet = RestActivityFlagSet(bitMask or value.bitMask)

    operator fun minus(value: RestActivityFlagSet) = RestActivityFlagSet(bitMask and value.bitMask.inv())

    companion object Serializer: BitmaskSerializer<RestActivityFlagSet>({bitmask -> RestActivityFlagSet(bitmask)})
}