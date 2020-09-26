package com.atlanta.project.entity.discord.channel

import com.atlanta.project.utils.type.ChannelType

/**
 * Represents a [Discord Channel](https://discord.com/developers/docs/resources/channel),
 * that has a variable [ChannelType]
 *
 * @since 0.1
 * @see ChannelType
 */
interface Channel {

    /**
     * Represents channel's id as Long (channel's snowflake)
     * It can be also interpreted as channel's creation date in ISO8601 format type.
     *
     * @since 0.1
     */
    val id: Long

}