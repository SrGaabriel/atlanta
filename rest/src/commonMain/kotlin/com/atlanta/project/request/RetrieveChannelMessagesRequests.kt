package com.atlanta.project.request

import com.atlanta.project.utils.Snowflake
import kotlinx.serialization.Serializable

@Serializable
data class GetChannelMessages(
    val around: Snowflake?,
    val before: Snowflake?,
    val after: Snowflake?,
    val limit: Int?
)