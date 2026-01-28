package br.com.rubensrodrigues.pantry_control.di.module

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.defaultRequest
import org.koin.dsl.module

val networkModule = module {
    single {
        HttpClient(CIO) {
            defaultRequest {
                url("https://www.api-pantry-control.rodroid.com.br/api/v1/")
            }
        }
    }
}