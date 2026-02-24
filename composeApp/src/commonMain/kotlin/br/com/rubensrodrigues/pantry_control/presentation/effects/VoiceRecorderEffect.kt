package br.com.rubensrodrigues.pantry_control.presentation.effects

import androidx.compose.runtime.Composable

@Composable
expect fun VoiceRecorderEffect(
    isPressed: Boolean,
    onRecordingStateChanged: (isRecording: Boolean) -> Unit,
    onFilePathReady: (result: FileResult?) -> Unit
)

data class FileResult(
    val filename: String,
    val absolutePath: String,
    val bytes: ByteArray,
)