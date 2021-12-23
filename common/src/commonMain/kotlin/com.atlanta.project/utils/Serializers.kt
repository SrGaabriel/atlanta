package com.atlanta.project.utils

import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlin.reflect.KClass

interface BitmaskHolder<T: BitmaskHolder<T>> {
    val bitMask: Int
}

open class BitmaskSerializer<T : BitmaskHolder<T>>(val scope: (Int) -> T): KSerializer<T> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("BitMaskSerializer", PrimitiveKind.INT)

    override fun deserialize(decoder: Decoder): T =
        scope(decoder.decodeInt())

    override fun serialize(encoder: Encoder, value: T) =
        encoder.encodeInt(value.bitMask)
}

abstract class DefaultIntIdEnumSerializationStrategy<E: Enum<E>>(private val values: Map<Int, E>): IntIdEnumSerializationStrategy<E> {
    override fun getValueByIdentifier(id: Int): E = values[id] ?: throw SerializationException("Received value is not registered in wrapper enum.")

    override fun getIdentifierFromValue(value: E): Int = values.filter { it.value == value }.firstNotNullOf { it.key }
}

interface IntIdEnumSerializationStrategy<E: Enum<E>> {
    fun getValueByIdentifier(id: Int): E
    fun getIdentifierFromValue(value: E): Int
}

open class IntIdSerializer<E: Enum<E>>(
    klass: KClass<E>,
    private val strategy: IntIdEnumSerializationStrategy<E>
) : KSerializer<E> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor(klass.simpleName!!, PrimitiveKind.INT)

    override fun serialize(encoder: Encoder, value: E) {
        encoder.encodeInt(strategy.getIdentifierFromValue(value))
    }

    override fun deserialize(decoder: Decoder): E =
        strategy.getValueByIdentifier(decoder.decodeInt())
}