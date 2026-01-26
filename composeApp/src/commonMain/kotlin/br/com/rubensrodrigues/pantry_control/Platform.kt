package br.com.rubensrodrigues.pantry_control

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform