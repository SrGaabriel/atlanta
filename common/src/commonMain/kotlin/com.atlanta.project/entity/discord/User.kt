package com.atlanta.project.entity.discord

import com.atlanta.project.Constants

interface User {
    /// The user's ID.
    val id: Long

    /// The user's name.
    val name: String
    /// The user's discriminator.
    val discriminator: Short
    /// The user's avatar hash (if any).
    val avatarHash: String?

    /// Boolean indicating whether the user is a bot or not.
    val bot: Boolean
    /// Boolean indicating whether the user is the system or not.
    val system: Boolean

    /// The user's avatar URL (if any).
    val avatarURL: String?
        get() = if (this.avatarHash.isNullOrEmpty()) null else "${Constants.cdnURL}/avatars/${this.id}/${this.avatarHash}.${if (this.avatarHash!!.startsWith("a_")) "gif" else "png"}"
    /// The user's default avatar url.
    val defaultAvatarURL: String
        get() = "${Constants.cdnURL}/embed/avatars/${this.discriminator}.png"
    /// The effective user avatar URL.
    val displayAvatarURL: String
        get() = if (this.avatarHash.isNullOrEmpty()) this.defaultAvatarURL else this.avatarURL!!
}