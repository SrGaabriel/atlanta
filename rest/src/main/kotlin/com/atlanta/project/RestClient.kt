package com.atlanta.project

import com.atlanta.project.service.ChannelService
import com.atlanta.project.service.MessageService
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.http.*
import kotlinx.serialization.ExperimentalSerializationApi

class RestClient(val token: String) {
    var apiVersion = 9
    var httpClient: HttpClient = HttpClient(CIO.create()) {
        install(JsonFeature) {
            serializer = KotlinxSerializer(kotlinx.serialization.json.Json { explicitNulls = false; ignoreUnknownKeys = true; })
            acceptContentTypes = acceptContentTypes + ContentType("application", "json")
        }
    }

    val channelService = ChannelService()
    val messageService = MessageService(this)
}