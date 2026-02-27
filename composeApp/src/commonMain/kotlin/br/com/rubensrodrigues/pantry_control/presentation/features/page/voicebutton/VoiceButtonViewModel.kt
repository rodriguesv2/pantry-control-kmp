package br.com.rubensrodrigues.pantry_control.presentation.features.page.voicebutton

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.rubensrodrigues.pantry_control.domain.usecase.SendSoundUseCase
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class VoiceButtonViewModel(
    private val sendSoundUseCase: SendSoundUseCase
): ViewModel() {

    private val _uiState = MutableStateFlow(VoiceButtonUiState())
    val uiState = _uiState.asStateFlow()

    private val _state = MutableSharedFlow<VoiceButtonState>()
    val state = _state.asSharedFlow()

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
        println("ViewModel.SendAudio - Passou aqui")
        viewModelScope.launch {
            _uiState.update { it.copy(loading = true) }
            val result = sendSoundUseCase(
                fileName = uiState.value.fileName ?: "",
                soundBytes = uiState.value.fileBytes ?: byteArrayOf()
            )

            _uiState.update { it.copy(loading = false) }
            result.fold(
                onSuccess = { response ->
                    _state.emit(
                        VoiceButtonState.GoToList(response)
                    )
                },
                onFailure = {}
            )
        }
    }
}