package com.atlanta.project.service

import com.atlanta.project.RestClient
import io.ktor.client.request.*

abstract class RestService(val client: RestClient) {
    suspend inline fun <reified T : Any> post(endpoint: String, dto: T) = post<T>(endpoint) {
        body = dto
    }

    suspend inline fun <reified T : Any> post(endpoint: String, scope: HttpRequestBuilder.() -> Unit = {}) = client.httpClient.post<T>("https://discord.com/api/v${client.apiVersion}/$endpoint", scope)
}