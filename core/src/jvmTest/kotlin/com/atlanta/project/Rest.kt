package com.atlanta.project

import com.atlanta.project.rest.response.ResponseMember
import com.atlanta.project.rest.response.ResponseMessage
import com.atlanta.project.rest.response.ResponseRole
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

fun main() {
    role()
    member()
    message()
}

fun member() {
    println(
        Json.decodeFromString<ResponseMember>("""
            {
              "nick": "NOT API SUPPORT",
              "roles": [],
              "joined_at": "2014-10-23T00:35:14.800Z",
              "deaf": false,
              "mute": false
            }
    """.trimIndent()
        )
    )
}

fun role() {
    println(
        Json.decodeFromString<ResponseRole>("""
            {
              "id": "41771983423143936",
              "name": "WE DEM BOYZZ!!!!!!",
              "color": 3447003,
              "hoist": true,
              "position": 1,
              "permissions": 66321471,
              "permissions_new": "66321471",
              "managed": false,
              "mentionable": false
            }
        """.trimIndent())
    )
}

fun message() {
    println(
        Json.decodeFromString<ResponseMessage>("""
            {
              "reactions": [
                {
                  "count": 1,
                  "me": false,
                  "emoji": {
                    "id": null,
                    "name": "🔥"
                  }
                }
              ],
              "attachments": [],
              "tts": false,
              "embeds": [],
              "timestamp": "2017-07-11T17:27:07.299000+00:00",
              "mention_everyone": false,
              "id": "334385199974967042",
              "pinned": false,
              "edited_timestamp": null,
              "author": {
                "username": "Mason",
                "discriminator": "9999",
                "id": "53908099506183680",
                "avatar": "a_bab14f271d565501444b2ca3be944b25"
              },
              "mention_roles": [],
              "content": "Supa Hot",
              "channel_id": "290926798999357250",
              "mentions": [],
              "type": 0
            }
        """.trimIndent())
    )
}