package br.com.rubensrodrigues.pantry_control.di.module

import br.com.rubensrodrigues.pantry_control.domain.usecase.SendSoundUseCase
import br.com.rubensrodrigues.pantry_control.domain.usecase.SendSoundUseCaseImpl
import org.koin.dsl.module

val useCaseModule = module {
    factory<SendSoundUseCase> { SendSoundUseCaseImpl(get()) }
}