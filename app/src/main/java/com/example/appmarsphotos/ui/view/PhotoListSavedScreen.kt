package com.example.appmarsphotos.ui.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.appmarsphotos.domain.model.RoverPhotoUiState
import com.example.appmarsphotos.ui.savedlist.MarsRoverSavedViewModel

@Composable
fun PhotoListSavedScreen(
    modifier: Modifier = Modifier,
    marsRoverSavedViewModel: MarsRoverSavedViewModel
) {
    val viewState by marsRoverSavedViewModel.marsPhotoUiSavedState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        marsRoverSavedViewModel.getAllSaved()
    }

    when (val roverPhotoUiState = viewState) {
        RoverPhotoUiState.Error -> Error()
        RoverPhotoUiState.Loading -> Loading()
        is RoverPhotoUiState.Success -> PhotoList(
            modifier = modifier,
            roverPhotoUiModelList = roverPhotoUiState.roverPhotoUiModelList,
            onClick = { roverPhotoUiModel ->
                marsRoverSavedViewModel.changeSaveStatus(roverPhotoUiModel)
            }
        )
    }
}