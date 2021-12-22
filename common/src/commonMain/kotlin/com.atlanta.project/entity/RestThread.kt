package com.atlanta.project.entity

import com.atlanta.project.utils.Snowflake
import com.atlanta.project.utils.Timestamp
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RestThreadMember(
    val id: Snowflake?,
    @SerialName("user_id") val userId: Snowflake?,
    val joinTimestamp: Timestamp,
    val flags: Int
)

@Serializable
data class RestThreadMetadata(
    val archived: Boolean,
    @SerialName("auto_archive_duration") val slowmode: Int,
    @SerialName("archive_timestamp") val archiveTimestamp: Timestamp,
    val locked: Boolean,
    val invitable: Boolean? = null
)