package com.atlanta.project.rest.response

import com.atlanta.project.rest.Snowflake
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseMember(
    @SerialName("user") val user: ResponseUser,
    @SerialName("nick") val nick: String?,
    @SerialName("roles") val roles: Array<Snowflake>,
)