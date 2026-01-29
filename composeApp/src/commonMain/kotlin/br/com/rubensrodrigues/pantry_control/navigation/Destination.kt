package br.com.rubensrodrigues.pantry_control.navigation

import androidx.navigation3.runtime.NavKey
import androidx.savedstate.serialization.SavedStateConfiguration
import kotlinx.serialization.Serializable
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic

sealed interface Destination: NavKey {
    @Serializable
    data object VoiceButton: Destination

    @Serializable
    data object Items: Destination
}

val config = SavedStateConfiguration {
    serializersModule = SerializersModule {
        polymorphic(NavKey::class) {
            subclass(Destination.VoiceButton::class, Destination.VoiceButton.serializer())
            subclass(Destination.Items::class, Destination.Items.serializer())
        }
    }
}
