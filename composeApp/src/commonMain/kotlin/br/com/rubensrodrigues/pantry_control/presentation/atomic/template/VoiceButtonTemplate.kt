package br.com.rubensrodrigues.pantry_control.presentation.atomic.template

import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun VoiceButtonTemplate(
    isRecording: Boolean = false,
    audioFilePath: String? = null,
    interactionSource: MutableInteractionSource
) {
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
    VoiceButtonTemplate(
        isRecording = true,
        interactionSource = MutableInteractionSource(),
        audioFilePath = "/path/to/audio.mp3"
    )
}