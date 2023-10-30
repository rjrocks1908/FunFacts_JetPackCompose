package com.haxon.funfacts.ui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.haxon.funfacts.data.UserDataUiEvents
import com.haxon.funfacts.data.UserInputScreenState

class UserInputViewModel : ViewModel() {

    val uiState = mutableStateOf(UserInputScreenState())

    fun onEvent(event: UserDataUiEvents) {
        when (event) {
            is UserDataUiEvents.UserNameEntered -> {
                uiState.value = uiState.value.copy(
                    nameEntered = event.name
                )
            }

            is UserDataUiEvents.AnimalSelected -> {
                uiState.value = uiState.value.copy(
                    animalEntered = event.animalValue
                )
            }
        }
    }

    fun isValidState() =
        uiState.value.animalEntered.isNotEmpty() and uiState.value.nameEntered.isNotEmpty()

}

