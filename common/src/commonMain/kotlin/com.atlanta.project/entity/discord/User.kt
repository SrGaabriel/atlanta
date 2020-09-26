package com.atlanta.project.entity.discord

import com.atlanta.project.utils.constants.Constants

interface User {

    /**
     * User's snowflake representation that can be also converted to
     * its creation date time, that you can see [here](https://i.imgur.com/UxWvdYD.png).
     *
     * @since 0.1
     */
    val id: Long

    /**
     * User's display name, can be changed by himself.
     * Don't recommend to store data in user's name, use [id] instead.
     *
     * @since 0.1
     */
    val name: String

    /**
     * User's discriminator that can be changed along [name].
     * It's 100% numeric but it's representation is a String to preserve an easier use.
     *
     * @since 0.1
     */
    val discriminator: String

    /**
     * User's avatar hash, null if user doesn't have one
     * or it is invalid.
     *
     * @since 0.1
     */
    val avatarHash: String?

    /**
     * Indicates if the respective user is a bot, or not.
     * If user is using a "self-bot", this will be false.
     *
     * @since 0.1
     */
    val isBot: Boolean

    /**
     * Indicates if the respective user is a bot, or not.
     * System users are normally the ones that publish discord announcements and warn yourself about your bot's token.
     *
     * @since 0.1
     */
    val isSystem: Boolean

    /**
     * User's avatar url, null if if user doesn't have one
     * or it is invalid.
     *
     * @since 0.1
     */
    val avatarURL: String?

    /**
     * User's default avatar url, it can be accessed by users [discriminator].
     * @since 0.1
     */
    val defaultAvatarURL: String

    /**
     * User's display avatar url, if user doesn't have one or not, it will be displayed
     * the exact same way.
     *
     * @since 0.1
     */
    val displayAvatarURL: String

}