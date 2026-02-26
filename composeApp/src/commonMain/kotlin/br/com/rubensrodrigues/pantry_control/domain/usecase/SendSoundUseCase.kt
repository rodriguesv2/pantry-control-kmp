package br.com.rubensrodrigues.pantry_control.domain.usecase

import br.com.rubensrodrigues.pantry_control.Constants
import br.com.rubensrodrigues.pantry_control.domain.entity.ItemEntity
import br.com.rubensrodrigues.pantry_control.domain.repository.ApiRepository
import br.com.rubensrodrigues.pantry_control.extensions.toInstant

interface SendSoundUseCase {
    suspend operator fun invoke(
        fileName: String,
        soundBytes: ByteArray,
    ): List<ItemEntity>
}

class SendSoundUseCaseImpl(
    private val apiRepository: ApiRepository,
) : SendSoundUseCase {
    override suspend fun invoke(
        fileName: String,
        soundBytes: ByteArray,
    ): List<ItemEntity> {
        val response = apiRepository.sendAudio(
            fileName = fileName,
            bytes = soundBytes,
        )

        return response
            .items
            .map { item ->
                ItemEntity(
                    name = item.name,
                    quantity = item.quantity,
                    unit = item.unit,
                    category = item.category,
                    expirationDate = item
                        .expirationDate
                        ?.toInstant(Constants.Date.EXPIRATION),
                )
            }
    }
}