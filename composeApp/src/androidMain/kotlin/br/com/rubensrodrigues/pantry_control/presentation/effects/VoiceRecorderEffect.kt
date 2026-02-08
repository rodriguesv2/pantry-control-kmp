package br.com.rubensrodrigues.pantry_control.presentation.effects

import android.Manifest
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import br.com.rubensrodrigues.pantry_control.service.AudioRecorder
import java.io.File

@Composable
actual fun VoiceRecorderEffect(
    isPressed: Boolean,
    onRecordingStateChanged: (isRecording: Boolean) -> Unit,
    onFilePathReady: (filePath: String?) -> Unit
) {
    val context = LocalContext.current
    val audioRecorder = remember { AudioRecorder(context) }
    var audioFile by remember { mutableStateOf<File?>(null) }
    var isRecording by remember { mutableStateOf(false) }

    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { isGranted ->
            if (isGranted) {
                isRecording = true
            }
        }
    )

    LaunchedEffect(isPressed) {
        if (isPressed) {
            permissionLauncher.launch(Manifest.permission.RECORD_AUDIO)
        } else {
            if (isRecording) {
                audioRecorder.stop()
                isRecording = false
            }
        }
    }

    LaunchedEffect(isRecording) {
        onRecordingStateChanged(isRecording)
        if (isRecording) {
            val file = File(context.cacheDir, "voice_memo.mp3").also {
                audioFile = it
                onFilePathReady(it.absolutePath)
            }
            audioRecorder.start(file)
        } else {
            onFilePathReady(null)
        }
    }
}