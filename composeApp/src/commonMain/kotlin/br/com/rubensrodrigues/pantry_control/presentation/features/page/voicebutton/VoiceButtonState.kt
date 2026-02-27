package br.com.rubensrodrigues.pantry_control.presentation.features.page.voicebutton

import br.com.rubensrodrigues.pantry_control.domain.entity.ItemEntity

sealed interface VoiceButtonState{
    data class GoToList(
        val items: List<ItemEntity>
    ): VoiceButtonState
}