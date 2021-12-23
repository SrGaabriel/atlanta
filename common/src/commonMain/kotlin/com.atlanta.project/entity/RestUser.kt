package com.atlanta.project.entity

import com.atlanta.project.utils.DefaultIntIdEnumSerializationStrategy
import com.atlanta.project.utils.Snowflake
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@Serializable
data class RestUser(
    val id: Snowflake,
    val username: String,
    val discriminator: String,
    val avatar: String? = null,
    @SerialName("bot") val isBot: Boolean? = null,
    @SerialName("system") val isSystem: Boolean? = null,
    @SerialName("mfa_enabled") val isMFAEnabled: Boolean? = null,
    val banner: String? = null,
    @SerialName("accent_color") val accentColor: Int? = null,
    val locale: String? = null,
    val verified: Boolean? = null,
    val email: String? = null,
    val flags: RestUserFlags? = null,
    @SerialName("premium_type") val premium: RestUserPremiumType? = null,
    @SerialName("public_flags") val publicFlags: RestUserFlags? = null
)

enum class RestUserFlag(val bitMask: Int) {
    STAFF(1 shl 0),
    PARTNER(1 shl 1),
    HYPESQUAD(1 shl 2),
    BUG_HUNTER_LEVEL_1(1 shl 3),
    HYPESQUAD_ONLINE_HOUSE_1(1 shl 6),
    HYPESQUAD_ONLINE_HOUSE_2(1 shl 7),
    HYPESQUAD_ONLINE_HOUSE_3(1 shl 8),
    PREMIUM_EARLY_SUPPORTER(1 shl 9),
    TEAM_PSEUDO_USER(1 shl 10),
    BUG_HUNTER_LEVEL_2(1 shl 14),
    VERIFIED_BOT(1 shl 16),
    VERIFIED_DEVELOPER(1 shl 17),
    CERTIFIED_MODERATOR(1 shl 18),
    BOT_HTTP_INTERACTIONS(1 shl 19)
}

@Serializable(with = RestUserFlagsSerializer::class)
data class RestUserFlags(val bitMask: Int) {

    operator fun plus(value: RestUserFlags): RestUserFlags = RestUserFlags(bitMask or value.bitMask)

    operator fun minus(value: RestUserFlags) = RestUserFlags(bitMask and value.bitMask.inv())

}

@Serializable(with = RestPremiumTypeSerializer::class)
enum class RestUserPremiumType(val id: Int) {

    NONE(0),
    CLASSIC(1),
    GAMER(2)

}

@Serializable
data class RestClientStatus(
    val desktop: String? = null,
    val mobile: String? = null,
    val web: String? = null
)

object RestPremiumTypeSerializer: KSerializer<RestUserPremiumType> {

    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("RestUserPremiumType", PrimitiveKind.INT)

    override fun deserialize(decoder: Decoder): RestUserPremiumType = RestUserPremiumType.values().first { it.id == decoder.decodeInt() }

    override fun serialize(encoder: Encoder, value: RestUserPremiumType) = encoder.encodeInt(value.id)

}

object RestUserFlagsSerializer: KSerializer<RestUserFlags> {

    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("permission_overwrites", PrimitiveKind.STRING)

    override fun deserialize(decoder: Decoder): RestUserFlags = RestUserFlags(decoder.decodeInt())

    override fun serialize(encoder: Encoder, value: RestUserFlags) = encoder.encodeInt(value.bitMask)

}