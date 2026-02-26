package br.com.rubensrodrigues.pantry_control.domain.entity

import kotlin.time.Instant

data class ItemEntity(
    val name: String,
    val quantity: Float,
    val unit: String?,
    val category: String?,
    val expirationDate: Instant?
)