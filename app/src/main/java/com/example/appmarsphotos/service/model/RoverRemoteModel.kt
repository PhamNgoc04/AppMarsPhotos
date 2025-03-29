package com.example.appmarsphotos.service.model

import com.google.gson.annotations.SerializedName

//Đại diện cho một Rover cụ thể (tên, nhiệm vụ, vị trí, trạng thái...).
data class RoverRemoteModel(
    val id: Int,
    @field:SerializedName("landing_date") val landingDate: String,
    @field:SerializedName("launch_date") val launchDate: String,
    val name: String,
    val status: String
)
