package com.example.appmarsphotos.service.model

import com.google.gson.annotations.SerializedName

//Dùng để chưa thông tin của camera trên Rover
data class CameraRemoteModel(
    @field:SerializedName("full_name") val fullName: String,
    val id: Int,
    val name: String,
    @field:SerializedName("rover_id") val roverId: Int
)
