package com.example.appmarsphotos.data

import com.example.appmarsphotos.domain.model.RoverManifestUiState
import com.example.appmarsphotos.domain.model.toUiModel
import com.example.appmarsphotos.service.MarsRoverManifestService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MarsRoverManifestRepo @Inject constructor(
    private val marsRoverManifestService: MarsRoverManifestService
) {
    //Lấy dữ liệu từ API của NASA và xử lý lỗi nếu có
    fun getMarsRoverManifest(roverName: String): Flow<RoverManifestUiState> = flow {
        try {
            emit(
                toUiModel(
                    marsRoverManifestService.getMarsRoverManifest(
                        roverName.lowercase()
                    )
                )
            )
        } catch (throwable: Throwable) {
            emit(RoverManifestUiState.Error)
        }
    }
}
