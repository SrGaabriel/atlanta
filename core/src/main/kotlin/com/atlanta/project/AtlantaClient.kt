package com.atlanta.project

import com.atlanta.project.entity.InternalSelfUser
import com.atlanta.project.entity.client.SelfUser

class AtlantaClient(internal val token: String): Client {

    override val self: SelfUser = InternalSelfUser(this)

}