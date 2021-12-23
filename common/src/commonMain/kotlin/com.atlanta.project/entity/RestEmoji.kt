package com.atlanta.project.entity

import com.atlanta.project.utils.DefaultIntIdEnumSerializationStrategy
import com.atlanta.project.utils.IntIdSerializer
import com.atlanta.project.utils.Snowflake
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RestEmoji(
    val id: Snowflake?,
    val name: String?,
    val roles: List<RestRole>? = null,
    @SerialName("user") val creator: RestUser? = null,
    @SerialName("require_colons") val colons: Boolean? = null,
    val managed: Boolean? = null,
    val animated: Boolean? = null,
    val available: Boolean? = null
)

@Serializable
data class RestSticker(
    val id: Snowflake,
    @SerialName("pack_id") val packId: Snowflake? = null,
    val name: String,
    val description: String? = null,
    val tags: String,
    @Deprecated("Previously the sticker asset hash, now an empty string.")
    val asset: String = "",
    val type: Int,
    @SerialName("format_type") val formatType: Int,
    val available: Boolean? = null,
    @SerialName("guild_id") val guildId: Snowflake? = null,
    val user: RestUser? = null,
    @SerialName("sort_value") val sortValue: Int? = null
)

@Serializable
data class RestStickerItem(
    val id: Snowflake,
    val name: String,
    @SerialName("format_type") val formatType: RestStickerFormatType
)

@Serializable(RestStickerFormatTypeSerializer::class)
enum class RestStickerFormatType(val value: Int) {
    PNG(1),
    APNG(2),
    LOTTIE(3);

    companion object: DefaultIntIdEnumSerializationStrategy<RestStickerFormatType>(values().associateBy { it.value })
}
object RestStickerFormatTypeSerializer: IntIdSerializer<RestStickerFormatType>(RestStickerFormatType::class, RestStickerFormatType)