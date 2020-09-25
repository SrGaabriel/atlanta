package com.atlanta.project.entity

import com.atlanta.project.AtlantaClient
import com.atlanta.project.utils.AtlantaExperimental
import com.atlanta.project.entity.client.SelfUser

@AtlantaExperimental
internal class InternalSelfUser(private val client: AtlantaClient): SelfUser {

    override val id: Long
        get() = TODO("Not yet implemented")
    override val name: String
        get() = TODO("Not yet implemented")
    override val discriminator: Short
        get() = TODO("Not yet implemented")

}