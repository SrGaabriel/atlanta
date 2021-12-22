package com.atlanta.project.utils

import kotlinx.datetime.Instant
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.Json

val DEFAULT_JSON = Json {
    ignoreUnknownKeys = true
}

@Serializable(with = TimestampSerializer::class)
data class Timestamp(
    val iso: String
) {
    @Transient val instant: Instant = Instant.parse(iso)
    @Transient val mills: Long = instant.toEpochMilliseconds()
}

object TimestampSerializer: KSerializer<Timestamp> {

    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("timestamp", PrimitiveKind.STRING)

    override fun deserialize(decoder: Decoder): Timestamp = Timestamp(decoder.decodeString())

    override fun serialize(encoder: Encoder, value: Timestamp) = encoder.encodeString(value.iso)

}

@Serializable(with = PermissionSerializer::class)
data class PermissionSet(val bitMask: Int) {

    operator fun plus(value: PermissionSet): PermissionSet = PermissionSet(bitMask or value.bitMask)

    operator fun minus(value: PermissionSet) = PermissionSet(bitMask and value.bitMask.inv())

}

object PermissionSerializer: KSerializer<PermissionSet> {

    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("permission_overwrites", PrimitiveKind.STRING)

    override fun deserialize(decoder: Decoder): PermissionSet = PermissionSet(decoder.decodeInt())

    override fun serialize(encoder: Encoder, value: PermissionSet) = encoder.encodeInt(value.bitMask)

}

@Serializable(with = SnowflakeSerializer::class)
data class Snowflake(val id: Long) {

    constructor(id: String): this(id.toLongOrNull() ?: error("Invalid snowflake $id."))

}

object SnowflakeSerializer: KSerializer<Snowflake> {

    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("snowflake", PrimitiveKind.STRING)

    override fun deserialize(decoder: Decoder): Snowflake = Snowflake(decoder.decodeString().toLongOrNull() ?: throw IllegalArgumentException("Invalid snowflake ${decoder.decodeString()}."))

    override fun serialize(encoder: Encoder, value: Snowflake) =  encoder.encodeString(value.id.toString())

}

fun Long.toSnowflake(): Snowflake = Snowflake(this)