package br.com.rubensrodrigues.pantry_control.presentation.features.page

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.rubensrodrigues.pantry_control.presentation.effects.VoiceRecorderEffect

@Composable
fun VoiceButtonPage() {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    var isRecording by remember { mutableStateOf(false) }
    var audioFilePath by remember { mutableStateOf<String?>(null) }

    VoiceRecorderEffect(
        isPressed = isPressed,
        onRecordingStateChanged = { isRecording = it },
        onFilePathReady = { audioFilePath = it }
    )

    Scaffold {
        Column(
            Modifier
                .padding(it)
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(if (isRecording) "Gravando..." else "Pressione para gravar")
            audioFilePath?.let { path ->
                Spacer(Modifier.height(16.dp))
                Text("Áudio salvo em: $path")
            }
            Spacer(Modifier.weight(1f))
            Button(
                onClick = { },
                interactionSource = interactionSource
            ) {
                Text("Pressione e Segure")
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    VoiceButtonPage()
}
