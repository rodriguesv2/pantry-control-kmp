package br.com.rubensrodrigues.pantry_control.domain.repository

import br.com.rubensrodrigues.pantry_control.data.model.AudioAnalyzedResponse

interface ApiRepository {
    suspend fun sendAudio(
        fileName: String,
        bytes: ByteArray,
    ): AudioAnalyzedResponse
}