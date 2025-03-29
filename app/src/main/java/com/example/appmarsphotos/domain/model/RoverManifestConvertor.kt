package com.example.appmarsphotos.domain.model

import com.example.appmarsphotos.service.model.RoverManifestRemoteModel

//Hàm toUiModel chuyển đổi dữ liệu từ RoverManifestRemoteModel(API) sang RoverManifestUiState (UI) để hiển thị lên giao diện
fun toUiModel(roverManifestRemoteModel: RoverManifestRemoteModel) : RoverManifestUiState =
    RoverManifestUiState.Success(roverManifestRemoteModel.photoManifest.photos.map { photo ->
        RoverManifestUiModel(
            sol = photo.sol.toString(),
            earthDate = photo.earthDate,
            photoNumber = photo.totalPhotos.toString()
        )
    }.sorted())