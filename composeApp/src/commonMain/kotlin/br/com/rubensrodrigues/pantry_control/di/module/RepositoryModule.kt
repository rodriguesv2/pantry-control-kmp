package br.com.rubensrodrigues.pantry_control.di.module

import br.com.rubensrodrigues.pantry_control.data.repository.ApiRepositoryImpl
import br.com.rubensrodrigues.pantry_control.domain.repository.ApiRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<ApiRepository> { ApiRepositoryImpl(get()) }
}