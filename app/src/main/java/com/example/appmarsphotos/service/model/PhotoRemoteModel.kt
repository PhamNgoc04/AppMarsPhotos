package com.example.appmarsphotos.service.model

import com.google.gson.annotations.SerializedName

//Đại diện cho một bức ảnh cụ thể từ Rover (URL, thời gian chụp, camera sử dụng...).
data class PhotoRemoteModel (
    val camera: CameraRemoteModel,
    @field:SerializedName("earth_date") val earthDate: String,
    val id: Int,
    @field:SerializedName("img_src") val imgSrc: String,
    val rover: RoverRemoteModel,
    val sol: Int
)