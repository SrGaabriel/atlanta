package com.atlanta.project.request.message

import com.atlanta.project.entity.*
import com.atlanta.project.utils.AtlantaExperimental
import com.atlanta.project.utils.Snowflake
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@AtlantaExperimental
// Files not supported
data class CreateMessageRequest(
    val content: String? = null,
    val tts: Boolean = false,
    val embeds: List<RestMessageEmbed> = emptyList(),
    @SerialName("allowed_mentions") val allowedMentions: RestMessageAllowedMentions? = null,
    @SerialName("message_reference") val messageReference: RestMessageReference? = null,
    val components: List<RestMessageComponent>? = null,
    @SerialName("sticker_id") val stickerIds: List<Snowflake>? = null,
    val attachments: List<RestAttachment>? = null
)