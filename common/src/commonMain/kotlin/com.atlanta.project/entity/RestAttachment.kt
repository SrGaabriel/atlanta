package com.atlanta.project.entity

import com.atlanta.project.utils.Snowflake
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RestAttachment(
    val id: Snowflake,
    @SerialName("filename") val fileName: String,
    val size: Int,
    val url: String,
    @SerialName("proxy_url") val proxyUrl: String,
    val height: Int? = null,
    val width: Int? = null
)