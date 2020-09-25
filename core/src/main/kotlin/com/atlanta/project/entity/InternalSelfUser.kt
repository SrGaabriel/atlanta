package com.atlanta.project.entity

import com.atlanta.project.AtlantaClient
import com.atlanta.project.entity.client.SelfUser

internal class InternalSelfUser(private val client: AtlantaClient): SelfUser {

    override val id: Long = TODO("Not yet implemented")
    override val name: String = TODO("Not yet implemented")
    override val discriminator: Short = TODO("Not yet implemented")

}