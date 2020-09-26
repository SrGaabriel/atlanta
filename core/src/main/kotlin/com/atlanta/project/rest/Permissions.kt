package com.atlanta.project.rest

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@Serializable
data class PermissionSet(val bitMask: Int) {

    operator fun plus(value: PermissionSet): PermissionSet = PermissionSet(bitMask or value.bitMask)

    operator fun minus(value: PermissionSet) = PermissionSet(bitMask and value.bitMask.inv())

}

class PermissionSerializer: KSerializer<PermissionSet> {

    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("permissions", PrimitiveKind.INT)

    override fun deserialize(decoder: Decoder): PermissionSet = PermissionSet(decoder.decodeInt())

    override fun serialize(encoder: Encoder, value: PermissionSet) = encoder.encodeInt(value.bitMask)

}