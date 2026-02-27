package br.com.rubensrodrigues.pantry_control.data.repository

import br.com.rubensrodrigues.pantry_control.data.model.AudioAnalyzedResponse
import br.com.rubensrodrigues.pantry_control.domain.repository.ApiRepository
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.forms.formData
import io.ktor.client.request.forms.submitFormWithBinaryData
import io.ktor.http.Headers
import io.ktor.http.HttpHeaders

class ApiRepositoryImpl(
    private val client: HttpClient,
) : ApiRepository {
    override suspend fun sendAudio(
        fileName: String,
        bytes: ByteArray
    ): AudioAnalyzedResponse {
        val response = client.submitFormWithBinaryData(
            url = "/api/v1/pantry/analyze-audio",
            formData = formData {
                append(
                    key = "file",
                    value = bytes,
                    headers = Headers.build {
                        append(HttpHeaders.ContentType, "audio/mpeg")
                        append(HttpHeaders.ContentDisposition, "filename=\"$fileName\"")
                    }
                )
            }
        )

        return response.body()
    }
}