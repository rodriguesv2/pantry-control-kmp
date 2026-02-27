package br.com.rubensrodrigues.pantry_control.presentation.navigation

import androidx.navigation3.runtime.NavKey
import androidx.savedstate.serialization.SavedStateConfiguration
import br.com.rubensrodrigues.pantry_control.domain.entity.ItemEntity
import kotlinx.serialization.Serializable
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic

sealed interface Destination: NavKey {
    @Serializable
    data object VoiceButton: Destination

    @Serializable
    data class Items(val items: List<ItemEntity>): Destination
}
