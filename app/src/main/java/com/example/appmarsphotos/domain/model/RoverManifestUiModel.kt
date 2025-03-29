package com.example.appmarsphotos.domain.model

//Dùng để quản lý trạng thái của RoverManifest
//Success: Lấy dữ liệu thành công
//Loading: Đang tải dữ liệu
//Error: Lỗi khi tải dữ liệu
//Được sử dụng trong RoverManifestViewModel
sealed class RoverManifestUiState{
    data class Success(
        val roverManifestUiModelList: List<RoverManifestUiModel>
    ) : RoverManifestUiState()
    object Loading : RoverManifestUiState()
    object Error : RoverManifestUiState()
}

data class RoverManifestUiModel(
    val sol: String,
    val earthDate: String,
    val photoNumber: String
) : Comparable<RoverManifestUiModel> {
    override fun compareTo(other: RoverManifestUiModel): Int = other.earthDate.compareTo(this.earthDate)

}