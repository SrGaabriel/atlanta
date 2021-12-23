package com.atlanta.project.request.message

import com.atlanta.project.entity.RestMessage
import kotlinx.serialization.Serializable

@Serializable
data class BulkDeleteMessagesRequest(
    val messages: List<RestMessage>
)