package br.com.rubensrodrigues.pantry_control.di

import br.com.rubensrodrigues.pantry_control.di.module.networkModule
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.includes

fun initKoin(config: KoinAppDeclaration? = null): KoinApplication {
    return startKoin {
        includes(config)
        modules(
            networkModule
        )
    }
}