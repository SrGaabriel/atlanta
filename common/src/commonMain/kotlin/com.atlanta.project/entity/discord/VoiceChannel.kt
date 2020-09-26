package com.atlanta.project.entity.discord

interface VoiceChannel: GuildChannel {
    /// The voice channel's bit rate.
    val bitrate: Int
    /// The voice channel's user limit (if any).
    val userLimit: Int?
}