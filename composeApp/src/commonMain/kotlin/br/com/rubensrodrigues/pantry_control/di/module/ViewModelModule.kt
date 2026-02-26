package br.com.rubensrodrigues.pantry_control.di.module

import br.com.rubensrodrigues.pantry_control.presentation.features.page.voicebutton.VoiceButtonViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {
    viewModelOf(::VoiceButtonViewModel)
}