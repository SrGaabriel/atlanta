package com.atlanta.project

import com.atlanta.project.entity.client.SelfUser
import com.atlanta.project.gateway.Authentication

class AtlantaClient(internal val authentication: Authentication): Client {

    override val self: SelfUser
        get() = TODO("Not yet implemented")

    fun login() {
        TODO("Not yet implemented")
    }

}