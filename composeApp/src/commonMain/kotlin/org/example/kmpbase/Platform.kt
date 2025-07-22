package org.example.kmpbase

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform