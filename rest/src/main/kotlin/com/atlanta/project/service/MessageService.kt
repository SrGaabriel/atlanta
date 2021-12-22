package com.atlanta.project.service

import com.atlanta.project.RestClient
import com.atlanta.project.request.message.CreateMessageRequest
import com.atlanta.project.utils.AtlantaExperimental
import io.ktor.client.request.*

class MessageService(client: RestClient): RestService(client) {
    @OptIn(AtlantaExperimental::class)
    suspend fun createMessage(channelId: Long, message: CreateMessageRequest) =
        post("channels/$channelId/messages", message)
}