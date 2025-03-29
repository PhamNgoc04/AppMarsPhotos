package com.example.appmarsphotos.ui.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.appmarsphotos.domain.model.RoverManifestUiState
import com.example.appmarsphotos.ui.manifestlist.MarsRoverManifestViewModel

//Chịu trách nhiệm hiển thị dữ liệu về nhật ký hoạt động của Rover
@Composable
fun ManifestScreen(
    modifier: Modifier,
    roverName: String?,
    marsRoverManifestViewModel: MarsRoverManifestViewModel, //ViewModel chịu trách nhiệm lấy dữ liệu từ repository
    onClick: (roverName: String, sol: String) -> Unit
) {
    //Lấy dữ liệu từ ViewModel
    //collectAsStateWithLifecycle() sẽ tự động hủy bỏ việc thu thập dữ liệu khi Composable không còn hoạt động
    val viewState by marsRoverManifestViewModel.roverManifestUiState.collectAsStateWithLifecycle()

    if (roverName != null) {
        LaunchedEffect(Unit) {
            marsRoverManifestViewModel.getMarsRoverManifest(roverName)
        }
        //hiển thị màn hình lỗi (Error) nếu dữ liệu không thể lấy được
        //hiển thị màn hình loading (Loading) khi dữ liệu đang tải
        //hiển thị danh sách nhật ký hoạt động của Rover nếu dữ liệu lấy được
        when (val roverManifestUiState = viewState) {
            RoverManifestUiState.Error -> Error()
            RoverManifestUiState.Loading -> Loading()
            is RoverManifestUiState.Success -> ManifestList(
                modifier = modifier,
                roverManifestUiModelList = roverManifestUiState.roverManifestUiModelList,
                roverName = roverName,
                onClick = onClick
            )
        }
    }
}