package br.com.rubensrodrigues.pantry_control.di.module

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import org.koin.dsl.module

val networkModule = module {
    single {
        HttpClient(CIO) {
            defaultRequest {
                url("https://www.api-pantry-control.rodroid.com.br/api/v1/")
            }
            install(Logging) {
                logger = Logger.DEFAULT
                level = LogLevel.ALL
            }
        }
    }
}