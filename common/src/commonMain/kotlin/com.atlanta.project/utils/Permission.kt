package com.atlanta.project.utils

enum class Permission(val bitMask: Int) {

    CREATE_INSTANT_INVITE(1 shl 0),

    KICK_MEMBERS(1 shl 1),

    BAN_MEMBERS(1 shl 2),

    ADMINISTRATOR(1 shl 3),

    MANAGE_CHANNELS(1 shl 4),

    MANAGE_GUILD(1 shl 5),

    ADD_REACTIONS(1 shl 6),

    VIEW_AUDIT_LOG(1 shl 7),

    PRIORITY_SPEAKER(1 shl 8),

    STREAM(1 shl 9),

    VIEW_CHANNEL(1 shl 10),

    SEND_MESSAGES(1 shl 11),

    SEND_TTS_MESSAGES(1 shl 12),

    MANAGE_MESSAGES(1 shl 13),

    EMBED_LINKS(1 shl 14),

    ATTACH_FILES(1 shl 15),

    READ_MESSAGE_HISTORY(1 shl 16),

    MENTION_EVERYONE(1 shl 17),

    USE_EXTERNAL_EMOJIS(1 shl 18),

    VIEW_GUILD_INSIGHTS(1 shl 19),

    CONNECT(1 shl 20),

    SPEAK(1 shl 21),

    MUTE_MEMBERS(1 shl 22),

    DEAFEN_MEMBERS(1 shl 23),

    MOVE_MEMBERS(1 shl 24),

    USE_VAD(1 shl 25),

    CHANGE_NICKNAME(1 shl 26),

    MANAGE_NICKNAMES(1 shl 27),

    MANAGE_ROLES(1 shl 28),

    MANAGE_WEBHOOKS(1 shl 29),

    MANAGE_EMOJIS_AND_STICKERS(1 shl 30),

    USE_APPLICATION_COMMANDS(1 shl 31),

    REQUEST_TO_SPEAK(1 shl 32),

    MANAGE_EVENTS(1 shl 33),

    MANAGE_THREADS(1 shl 34),

    CREATE_PUBLIC_THREADS(1 shl 35),

    CREATE_PRIVATE_THREADS(1 shl 36),

    USE_EXTERNAL_STICKERS(1 shl 37),

    SEND_MESSAGES_IN_THREADS(1 shl 38),

    START_EMBEDDED_ACTIVITIES(1 shl 39),

    MODERATE_MEMBERS(1 shl 40);
}