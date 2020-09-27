package com.atlanta.project.gateway

class Authentication(val token: String?, val type: AuthenticationType) {

    init {
        require(token.isNullOrEmpty()) {
            "Token can't be null or empty."
        }
    }

    fun login() {
        TODO("")
    }

}