package com.atlanta.project.service

import com.atlanta.project.RestClient
import com.atlanta.project.entity.RestMessage
import com.atlanta.project.request.message.CreateMessageRequest
import com.atlanta.project.request.message.EditMessageRequest
import com.atlanta.project.utils.AtlantaExperimental
import io.ktor.client.request.*

class MessageService(client: RestClient): RestService(client) {
    @OptIn(AtlantaExperimental::class)
    suspend fun createMessage(channelId: Long, create: CreateMessageRequest): Unit =
        post("channels/$channelId/messages", create)

    // TODO: fix
    @AtlantaExperimental
    suspend fun editMessage(channelId: Long, messageId: Long, edit: EditMessageRequest): Unit =
        patch("channels/$channelId/messages/$messageId", edit)
}