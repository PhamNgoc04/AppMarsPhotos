package com.example.appmarsphotos.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

//Tạo ra 1 bảng trong database với tên là rover_photo
@Entity(tableName = "rover_photo")
data class MarsRoverSavedLocalModel(
    @PrimaryKey @field:SerializedName("rover_photo_id") val roverPhotoId: Int,
    @field:SerializedName("rover_photo") val roverName: String = "",
    @field:SerializedName("img_src") val imgSrc: String = "",
    @field:SerializedName("sol") val sol: String = "",
    @field:SerializedName("earth_date") val earthDate: String = "",
    @field:SerializedName("camera_full_name") val cameraFullName: String = ""
)