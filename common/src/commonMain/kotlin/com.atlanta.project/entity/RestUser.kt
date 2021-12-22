package com.atlanta.project.entity

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
    val avatar: String?,
    val isBot: Boolean? = null,
    val isSystem: Boolean? = null,
    @SerialName("mfa_enabled") val isMFAEnabled: Boolean? = null,
    val locale: String? = null,
    val verified: Boolean? = null,
    val email: String? = null,
    val flags: Int? = null,
    @SerialName("premium_type") val premium: RestUserPremiumType? = null,
    @SerialName("public_flags") val publicFlags: Int? = null
)

@Serializable(with = RestPremiumTypeSerializer::class)
enum class RestUserPremiumType(val id: Int) {

    NONE(0),
    CLASSIC(1),
    GAMER(2)

}

object RestPremiumTypeSerializer: KSerializer<RestUserPremiumType> {

    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("premium_type", PrimitiveKind.INT)

    override fun deserialize(decoder: Decoder): RestUserPremiumType = RestUserPremiumType.values().first { it.id == decoder.decodeInt() }

    override fun serialize(encoder: Encoder, value: RestUserPremiumType) = encoder.encodeInt(value.id)

}