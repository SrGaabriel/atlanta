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

@Serializable(with = RestUserFlags.Serializer::class)
data class RestUserFlags(override val bitMask: Int): BitmaskHolder<RestUserFlags> {

    operator fun plus(value: RestUserFlags): RestUserFlags = RestUserFlags(bitMask or value.bitMask)

    operator fun minus(value: RestUserFlags) = RestUserFlags(bitMask and value.bitMask.inv())

    companion object Serializer: BitmaskSerializer<RestUserFlags>({bitmask -> RestUserFlags(bitmask)})
}

@Serializable(with = RestPremiumTypeSerializer::class)
enum class RestUserPremiumType(val id: Int) {

    NONE(0),
    CLASSIC(1),
    GAMER(2);

    companion object: DefaultIntIdEnumSerializationStrategy<RestUserPremiumType>(values().associateBy { it.id })
}
object RestPremiumTypeSerializer: IntIdSerializer<RestUserPremiumType>(RestUserPremiumType::class, RestUserPremiumType)

@Serializable
data class RestClientStatus(
    val desktop: String? = null,
    val mobile: String? = null,
    val web: String? = null
)