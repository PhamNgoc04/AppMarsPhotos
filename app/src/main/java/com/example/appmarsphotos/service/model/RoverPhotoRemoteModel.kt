package com.example.appmarsphotos.service.model

//Có thể chứa danh sách ảnh liên quan đến một Rover nhất định.
data class RoverPhotoRemoteModel (
    val photos: List<PhotoRemoteModel>
)

/*
RoverPhotoRemoteModel
 └──> List<PhotoRemoteModel>
       ├──> CameraRemoteModel
       ├──> RoverRemoteModel
 */