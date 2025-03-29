package com.example.appmarsphotos.domain.model

//Dùng để quản lý trạng thái của RoverPhoto
//Success: Lấy dữ liệu thành công
//Loading: Đang tải dữ liệu
//Error: Lỗi khi tải dữ liệu
//Được sử dụng trong RoverPhotoViewModel
sealed class RoverPhotoUiState {
    data class Success(
        val roverPhotoUiModelList: List<RoverPhotoUiModel>
    ) : RoverPhotoUiState()
    object Loading : RoverPhotoUiState()
    object Error : RoverPhotoUiState()
}

data class RoverPhotoUiModel(
    val id: Int,
    val roverName: String,
    val imgSrc: String,
    val sol: String,
    val earthDate: String,
    val cameraFullName: String,
    val isSaved: Boolean
)