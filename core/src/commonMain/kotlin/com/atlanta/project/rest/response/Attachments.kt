package com.atlanta.project.rest.response

import com.atlanta.project.rest.Snowflake
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseAttachment(
    @SerialName("id") val id: Snowflake,
    @SerialName("filename") val fileName: String,
    @SerialName("size") val size: Int,
    @SerialName("url") val url: String,
    @SerialName("proxy_url") val proxyUrl: String,
    @SerialName("height") val height: Int? = null,
    @SerialName("width") val width: Int? = null
)