package com.atlanta.project

import com.atlanta.project.entity.client.SelfUser
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

interface Client: CoroutineScope {

    val self: SelfUser

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Default

}