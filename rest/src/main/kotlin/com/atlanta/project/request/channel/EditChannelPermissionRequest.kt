package com.atlanta.project.request.channel

data class EditChannelPermissionRequest(
    val allow: String,
    val deny: String,
    val type: Int
)