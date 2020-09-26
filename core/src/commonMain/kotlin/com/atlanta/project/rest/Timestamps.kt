package com.atlanta.project.rest

import kotlinx.datetime.Instant
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@Serializable(with = TimestampSerializer::class)
data class Timestamp(
    val iso: String,
    @Transient val instant: Instant = Instant.parse(iso),
    @Transient val mills: Long = instant.toEpochMilliseconds()
)

object TimestampSerializer: KSerializer<Timestamp> {

    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("timestamp", PrimitiveKind.STRING)

    override fun deserialize(decoder: Decoder): Timestamp = Timestamp(decoder.decodeString())

    override fun serialize(encoder: Encoder, value: Timestamp) = encoder.encodeString(value.iso)

}