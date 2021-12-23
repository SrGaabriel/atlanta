package com.atlanta.project.request.channel

import com.atlanta.project.entity.RestChannelEntityType
import com.atlanta.project.utils.Timestamp
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StartThreadWithMessage(
    val name: String,
    @SerialName("autor_archive_duration") val autoArchiveDuration: Int?,
    @SerialName("rate_limit_per_user") val slowmode: Int? = null
)

@Serializable
data class StartThreadWithoutMessage(
    val name: String,
    @SerialName("autor_archive_duration") val autoArchiveDuration: Int?,
    val type: RestChannelEntityType,
    val invitable: Boolean? = null,
    @SerialName("rate_limit_per_user") val slowmode: Int? = null
)

/**
 * This is the same structure as when requesting for [private, private joined] archived threads.
 * (and of course, public archived threads)
 */
@Serializable
data class ListPublicArchivedThreadsRequest(
    val before: Timestamp? = null,
    val limit: Int? = null
)