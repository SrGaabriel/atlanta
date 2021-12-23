package com.atlanta.project.response

import com.atlanta.project.entity.RestChannel
import com.atlanta.project.entity.RestThreadMember
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * This is the same structure as when receiving [public, private, joined private] archived threads.
 * (and of course, active threads)
 */
@Serializable
data class ListActiveThreadsResponse(
    val threads: List<RestChannel>,
    val members: List<RestThreadMember>,
    @SerialName("has_more") val hasMore: Boolean
)