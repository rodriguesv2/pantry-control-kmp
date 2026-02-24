package br.com.rubensrodrigues.pantry_control.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AudioAnalyzedResponse(
    val items: List<AnalyzedItem>,
)

@Serializable
data class AnalyzedItem(
    val name: String,
    val quantity: Float,
    val unit: String?,
    val category: String?,
    @SerialName("expiration_date") val expirationDate: String?,
    @SerialName("original_text") val originalText: String?,
)
