package br.com.rubensrodrigues.pantry_control.presentation.features.page.voicebutton

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import br.com.rubensrodrigues.pantry_control.presentation.atomic.template.VoiceButtonTemplate
import br.com.rubensrodrigues.pantry_control.presentation.effects.VoiceRecorderEffect

@Composable
fun VoiceButtonPage(
    viewModel: VoiceButtonViewModel,
) {
    val uiState by viewModel.uiState.collectAsState()

    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    var isRecording by remember { mutableStateOf(false) }

    VoiceRecorderEffect(
        isPressed = isPressed,
        onRecordingStateChanged = { isRecording = it },
        onFilePathReady = { result ->
            viewModel.saveFileData(
                fileName = result?.filename,
                absolutePath = result?.absolutePath,
                fileBytes = result?.bytes,
            )
            if (result != null) {
                viewModel.sendAudio()
            }
        }
    )

    VoiceButtonTemplate(
        isRecording = isRecording,
        audioFilePath = uiState.fileAbsolutePath,
        interactionSource = interactionSource,
    )
}
