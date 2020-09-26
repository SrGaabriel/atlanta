package com.atlanta.project

import com.atlanta.project.entity.client.SelfUser

class AtlantaClient(internal val token: String): Client {

    override val self: SelfUser
        get() = TODO("Not yet implemented")

    fun login() {
        TODO("Not yet implemented")
    }

}