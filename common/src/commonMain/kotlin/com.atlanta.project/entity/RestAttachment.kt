package com.atlanta.project.entity

import com.atlanta.project.utils.Snowflake
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RestAttachment(
    @SerialName("id") val id: Snowflake,
    @SerialName("filename") val fileName: String,
    @SerialName("size") val size: Int,
    @SerialName("url") val url: String,
    @SerialName("proxy_url") val proxyUrl: String,
    @SerialName("height") val height: Int? = null,
    @SerialName("width") val width: Int? = null
)