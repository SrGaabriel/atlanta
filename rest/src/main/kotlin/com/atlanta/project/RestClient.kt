package com.atlanta.project

import io.ktor.client.*
import io.ktor.client.engine.cio.*

class RestClient(val token: String) {
    var apiVersion = 8
    var httpClient: HttpClient = HttpClient(CIO.create()) {}
}