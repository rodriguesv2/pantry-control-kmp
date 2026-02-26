package br.com.rubensrodrigues.pantry_control.presentation.features.page.voicebutton

import androidx.lifecycle.ViewModel
import br.com.rubensrodrigues.pantry_control.domain.usecase.SendSoundUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class VoiceButtonViewModel(
    private val sendSoundUseCase: SendSoundUseCase
): ViewModel() {

    private val _uiState = MutableStateFlow(VoiceButtonUiState())
    val uiState = _uiState.asStateFlow()

    fun saveFileData(
        fileName: String?,
        absolutePath: String?,
        fileBytes: ByteArray?
    ) {
        _uiState.update {
            it.copy(
                fileName = fileName,
                fileAbsolutePath = absolutePath,
                fileBytes = fileBytes
            )
        }
    }

    fun sendAudio() {
        //
    }
}