package com.atlanta.project.request.channel

import com.atlanta.project.utils.Snowflake
import kotlinx.serialization.Serializable

@Serializable
data class GetChannelMessagesRequest(
    val around: Snowflake?,
    val before: Snowflake?,
    val after: Snowflake?,
    val limit: Int?
)