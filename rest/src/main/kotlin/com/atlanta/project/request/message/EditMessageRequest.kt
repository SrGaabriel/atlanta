package com.atlanta.project.request.message

import com.atlanta.project.entity.RestAttachment
import com.atlanta.project.entity.RestMessageAllowedMentions
import com.atlanta.project.entity.RestMessageComponent
import com.atlanta.project.entity.RestMessageEmbed
import com.atlanta.project.utils.AtlantaExperimental
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@AtlantaExperimental
// Files not supported
data class EditMessageRequest(
    val content: String? = null,
    val embeds: List<RestMessageEmbed>? = null,
    val flags: Int? = null,
    @SerialName("allowed_mentions") val allowedMentions: RestMessageAllowedMentions? = null,
    val components: List<RestMessageComponent>? = null,
    val attachments: List<RestAttachment>? = null
)