package br.com.rubensrodrigues.pantry_control.extensions

import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.format.FormatStringsInDatetimeFormats
import kotlinx.datetime.format.byUnicodePattern
import kotlinx.datetime.toInstant
import kotlin.time.Instant

@OptIn(FormatStringsInDatetimeFormats::class)
fun String.toInstant(stringFormatted: String): Instant {
    val format = LocalDateTime.Format {
        byUnicodePattern(stringFormatted)
    }

    return LocalDateTime.parse(
        input = this,
        format = format
    ).toInstant(TimeZone.currentSystemDefault())
}