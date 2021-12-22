package com.atlanta.project.request.message

import com.atlanta.project.utils.Snowflake
import kotlinx.serialization.Serializable

@Serializable
data class GetMessageReactionsRequest(
    val after: Snowflake? = null,
    val limit: Int? = null
)