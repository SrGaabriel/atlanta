package com.atlanta.project.entity.discord

interface User {

    val id: Long

    val name: String
    val discriminator: Short

}