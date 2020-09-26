@file:Suppress("EXPERIMENTAL_API_USAGE", "unused")

package com.atlanta.project.event

import com.atlanta.project.Client
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*

val eventChannel = BroadcastChannel<Event>(Channel.CONFLATED)
val eventFlow = eventChannel.asFlow()

inline fun <reified T : Event> Client.on(
    scope: CoroutineScope = this,
    noinline callback: suspend T.() -> Unit
): Job = eventFlow.buffer(Channel.UNLIMITED).filterIsInstance<T>().onEach(callback).launchIn(scope)

suspend inline fun <reified T : Event> Client.await(
    scope: CoroutineScope = this,
    timeout: Long = 0
): T? = withTimeoutOrNull(timeout) {
    suspendCancellableCoroutine<T> { continuation ->
        scope.launch {
            val event = eventFlow.buffer(Channel.UNLIMITED).filterIsInstance<T>().first()
            continuation.resume(event) {}
        }
    }
}

suspend inline fun <reified T : Event> Client.publish(
    event: T
): Unit = eventChannel.send(event)