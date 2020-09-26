package com.atlanta.project.entity.discord

interface GuildChannel {
    /// The guild that the channel belongs to.
    val guild: Guild
    /// owo.
    val permissionOverwrites: Int
    /// The relative channel position.
    val position: Int
    /// The category ID that the channel belongs to.
    val parentID: Long?
}