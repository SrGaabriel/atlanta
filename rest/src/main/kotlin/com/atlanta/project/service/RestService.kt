package com.atlanta.project.service

import com.atlanta.project.RestClient
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

abstract class RestService(val client: RestClient) {
    suspend inline fun <reified T : Any, reified R : Any> post(endpoint: String, dto: T) = post<R>(endpoint) {
        header(HttpHeaders.ContentType, "application/json; charset=utf-8")
        header(HttpHeaders.Authorization, "Bot ${client.token}")
        body = dto
    }

    suspend inline fun <reified T : Any> post(endpoint: String, scope: HttpRequestBuilder.() -> Unit = {}) = client.httpClient.post<T>("https://discord.com/api/v${client.apiVersion}/$endpoint", scope)

    suspend inline fun <reified T : Any, reified R : Any> patch(endpoint: String, dto: T) = post<R>(endpoint) {
        header(HttpHeaders.ContentType, "application/json; charset=utf-8")
        header(HttpHeaders.Authorization, "Bot ${client.token}")
        body = dto
    }

    suspend inline fun <reified T : Any> patch(endpoint: String, scope: HttpRequestBuilder.() -> Unit = {}) = client.httpClient.patch<T>("https://discord.com/api/v${client.apiVersion}/$endpoint", scope)
}