package com.atlanta.project.rest

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

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