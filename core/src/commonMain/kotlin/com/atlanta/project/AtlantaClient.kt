package com.atlanta.project

import com.atlanta.project.utils.AtlantaExperimental
import com.atlanta.project.entity.InternalSelfUser
import com.atlanta.project.entity.client.SelfUser

class AtlantaClient(internal val token: String): Client {

    @AtlantaExperimental
    override val self: SelfUser = InternalSelfUser(this)

    fun login() {
        TODO("Not implemented yet.")
    }

}