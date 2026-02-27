package br.com.rubensrodrigues.pantry_control.extensions

import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.atStartOfDayIn
import kotlinx.datetime.format.FormatStringsInDatetimeFormats
import kotlinx.datetime.format.byUnicodePattern
import kotlinx.datetime.toInstant
import kotlin.time.Instant

@OptIn(FormatStringsInDatetimeFormats::class)
fun String.toInstant(stringFormatted: String): Instant {
    try {
        val format = LocalDateTime.Format {
            byUnicodePattern(stringFormatted)
        }

        return LocalDateTime.parse(
            input = this,
            format = format
        ).toInstant(TimeZone.currentSystemDefault())
    } catch (e: IllegalArgumentException) {
        val format = LocalDate.Format {
            byUnicodePattern(stringFormatted)
        }

        return LocalDate.parse(
            input = this,
            format = format
        ).atStartOfDayIn(TimeZone.currentSystemDefault())
    }
}
