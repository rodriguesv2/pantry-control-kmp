package br.com.rubensrodrigues.pantry_control.presentation.features.page.voicebutton

data class VoiceButtonUiState(
    val loading: Boolean = false,
    val fileName: String? = null,
    val fileAbsolutePath: String? = null,
    val fileBytes: ByteArray? = null,
)