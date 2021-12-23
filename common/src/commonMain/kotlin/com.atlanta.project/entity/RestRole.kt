package com.atlanta.project.entity

import com.atlanta.project.utils.PermissionSet
import com.atlanta.project.utils.Snowflake
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RestRole(
    val id: Snowflake,
    val name: String,
    val color: Int,
    val hoist: Boolean,
    val icon: String? = null,
    @SerialName("unicode_emoji") val unicodeEmoji: String? = null,
    val position: Int,
    val permissions: PermissionSet,
    val managed: Boolean,
    val mentionable: Boolean,
    val tags: RestRoleTags? = null
)

@Serializable
data class RestRoleTags(
    @SerialName("bot_id") val botId: Snowflake? = null,
    @SerialName("integration_id") val integrationId: Snowflake? = null,
    @SerialName("premium_subscriber") val premiumSubscriber: Boolean? = null,
)