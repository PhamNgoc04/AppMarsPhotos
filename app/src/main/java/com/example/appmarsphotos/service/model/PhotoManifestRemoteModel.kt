package com.example.appmarsphotos.service.model

import com.google.gson.annotations.SerializedName

//Dùng để lưu trữ thông tin tổng hợp về ảnh được chụp trên Rover, liên kết với ManifestPhotoRemoteModel
data class PhotoManifestRemoteModel (
    @field:SerializedName("landing_date") val landingDate: String,
    @field:SerializedName("launch_date") val launchDate: String,
    @field:SerializedName("max_date") val maxDate: String,
    @field:SerializedName("max_sol") val maxSol: String,
    val name:String,
    val photos: List<ManifestPhotoRemoteModel>,
    val status: String,
    @field:SerializedName("total_photos") val totalPhotos: Int
)