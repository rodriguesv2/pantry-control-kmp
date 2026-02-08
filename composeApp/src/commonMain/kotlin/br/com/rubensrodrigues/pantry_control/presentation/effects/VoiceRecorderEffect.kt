package br.com.rubensrodrigues.pantry_control.presentation.effects

import androidx.compose.runtime.Composable

@Composable
expect fun VoiceRecorderEffect(
    isPressed: Boolean,
    onRecordingStateChanged: (isRecording: Boolean) -> Unit,
    onFilePathReady: (filePath: String?) -> Unit
)