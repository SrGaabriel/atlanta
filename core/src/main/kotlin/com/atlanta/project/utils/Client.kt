package com.atlanta.project.utils

import com.atlanta.project.AtlantaClient
import com.atlanta.project.Client
import com.atlanta.project.exception.InvalidClientException

class ClientBuilder {

    var token: String? = null

    fun build(): Client {
        return AtlantaClient(token ?: throw InvalidClientException("Client's token was not defined."))
    }

}

fun client(builder: ClientBuilder.() -> Unit): Client = ClientBuilder().apply(builder).build()