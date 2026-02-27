package br.com.rubensrodrigues.pantry_control.di

import br.com.rubensrodrigues.pantry_control.di.module.networkModule
import br.com.rubensrodrigues.pantry_control.di.module.repositoryModule
import br.com.rubensrodrigues.pantry_control.di.module.useCaseModule
import br.com.rubensrodrigues.pantry_control.di.module.viewModelModule
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(config: KoinAppDeclaration? = null): KoinApplication {
    return startKoin {
        config?.invoke(this)
        modules(
            networkModule,
            repositoryModule,
            viewModelModule,
            useCaseModule,
        )
    }
}