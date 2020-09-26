package com.atlanta.project.entity.discord.guild

import com.atlanta.project.utils.type.ChannelType

/**
 * Represents a [Discord Guild](https://discord.com/developers/docs/resources/guild) with a variable [ChannelType]
 *
 * @since 0.1
 */
interface Guild {

    /**
     * Guild's snowflake representation that can be also converted to
     * its creation date time, that you can see [here](https://i.imgur.com/UxWvdYD.png).
     *
     * @since 0.1
     */
    val id: Long
}