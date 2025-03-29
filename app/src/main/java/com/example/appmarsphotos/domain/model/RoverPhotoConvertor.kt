package com.example.appmarsphotos.domain.model

import com.example.appmarsphotos.db.MarsRoverSavedLocalModel

//Chuyển đổi từ RoverPhotoUiModel (UI) sang MarsRoverSavedLocalModel (Database - Room)
fun toDbModel(roverPhotoUiModel: RoverPhotoUiModel): MarsRoverSavedLocalModel =
    MarsRoverSavedLocalModel(
        roverPhotoId = roverPhotoUiModel.id,
        roverName = roverPhotoUiModel.roverName,
        imgSrc = roverPhotoUiModel.imgSrc,
        sol = roverPhotoUiModel.sol,
        earthDate = roverPhotoUiModel.earthDate,
        cameraFullName = roverPhotoUiModel.cameraFullName
    )

// Chuyển đổi từ MarsRoverSavedLocalModel (Database - Room) sang RoverPhotoUiModel (UI).
fun toUiModel(marsRoverSavedLocalModelList: List<MarsRoverSavedLocalModel>) =
    marsRoverSavedLocalModelList.map { photo ->
        RoverPhotoUiModel(
            id = photo.roverPhotoId,
            roverName = photo.roverName,
            imgSrc = photo.imgSrc,
            sol = photo.sol,
            earthDate = photo.earthDate,
            cameraFullName = photo.cameraFullName,
            isSaved = true
        )
    }