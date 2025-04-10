package com.example.appmarsphotos.domain.model

import com.example.appmarsphotos.R

//Được hiển thị trong UI khi người dùng chọn Rover để xem thông tin ảnh.
val roverUiModelList = listOf(
    RoverUiModel("Perseverance", R.drawable.perseverance, landingDate = "18 February 2021", distance = "12.56 km"),
    RoverUiModel("Curiosity", R.drawable.curiosity, landingDate = "6 August 2012", distance = "29.27 km"),
    RoverUiModel("Opportunity", R.drawable.opportunity, landingDate = "25 January 2004", distance = "45.16 km"),
    RoverUiModel("Spirit", R.drawable.spirit, landingDate = "4 January 2004", distance = "7.73 km")
)