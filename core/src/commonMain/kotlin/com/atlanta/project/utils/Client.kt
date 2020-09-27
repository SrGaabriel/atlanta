package com.atlanta.project.utils

import com.atlanta.project.AtlantaClient
import com.atlanta.project.Client
import com.atlanta.project.exception.InvalidClientException
import com.atlanta.project.gateway.Authentication
import com.atlanta.project.gateway.AuthenticationType

class ClientBuilder internal constructor(private val type: AuthenticationType) {

    var token: String? = null

    fun build(): Client {
        return AtlantaClient(Authentication(token, type))
    }

}

fun client(type: AuthenticationType = AuthenticationType.BOT, block: ClientBuilder.() -> Unit): Client = ClientBuilder(type).apply(block).build()