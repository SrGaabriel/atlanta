@file:OptIn(FlowPreview::class, ExperimentalCoroutinesApi::class)

package com.atlanta.project

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*

abstract class Event(val shardId: Int)

interface EventSupplier: CoroutineScope

val eventChannel = BroadcastChannel<Event>(Channel.CONFLATED)
val eventFlow = eventChannel.asFlow()

inline fun <reified T : Event> EventSupplier.on(
    scope: CoroutineScope = this,
    noinline callback: suspend T.() -> Unit
): Job = eventFlow.buffer(Channel.UNLIMITED).filterIsInstance<T>().onEach(callback).launchIn(scope)

suspend inline fun <reified T : Event> EventSupplier.await(
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

suspend inline fun <reified T : Event> EventSupplier.publish(
    event: T
): Unit = eventChannel.send(event)