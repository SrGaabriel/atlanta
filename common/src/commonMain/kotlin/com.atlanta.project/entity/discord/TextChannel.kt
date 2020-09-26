package com.atlanta.project.entity.discord

interface TextChannel: GuildChannel {
    /// The channel's topic (if any).
    val topic: String?
    /// Boolean indicating whether the channel is marked as NSFW or not.
    val nsfw: Boolean
    /// The channel's last message id.
    val lastMessageID: Long
    /// The channel's last ping timestamp.
    val lastPinTimestamp: String
    /// How much time does it need between sending messages in this channel.
    val rateLimitPerUser: Int
}