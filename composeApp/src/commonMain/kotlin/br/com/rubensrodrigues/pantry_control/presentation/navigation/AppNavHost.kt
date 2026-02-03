package br.com.rubensrodrigues.pantry_control.presentation.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import br.com.rubensrodrigues.pantry_control.presentation.features.page.VoiceButtonPage

@Composable
fun AppNavHost() {
    val backStackList = remember { mutableStateListOf<Destination>(Destination.VoiceButton) }

    NavDisplay(
        backStack = backStackList,
        onBack = { backStackList.removeLastOrNull() },
        entryProvider = { key ->
            when (key) {
                Destination.VoiceButton -> NavEntry(key) { VoiceButtonPage() }
                Destination.Items -> NavEntry(key) { Text("Item") }
            }
        }
    )
}