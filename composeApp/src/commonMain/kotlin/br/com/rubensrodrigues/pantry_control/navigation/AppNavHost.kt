package br.com.rubensrodrigues.pantry_control.navigation

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay

@Composable
fun AppNavHost() {
    val backstack = rememberNavBackStack(config, Destination.VoiceButton)


}