package com.example.appmarsphotos.service.model

import com.google.gson.annotations.SerializedName

//Lưu trữ thông tin chung về một Rover (tên, ngày khởi động, trạng thái hoạt động...).
data class RoverManifestRemoteModel(
    @field:SerializedName("photo_manifest") val photoManifest: PhotoManifestRemoteModel
)

/*
RoverManifestRemoteModel
 └──> PhotoManifestRemoteModel
       └──> List<ManifestPhotoRemoteModel>
 */