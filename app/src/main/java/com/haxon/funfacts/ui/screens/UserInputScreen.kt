package com.haxon.funfacts.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.haxon.funfacts.R
import com.haxon.funfacts.data.UserDataUiEvents
import com.haxon.funfacts.ui.AnimalCard
import com.haxon.funfacts.ui.AppComponents.UIS_TOP_BAR_HEADING
import com.haxon.funfacts.ui.ButtonComponent
import com.haxon.funfacts.ui.TextComponent
import com.haxon.funfacts.ui.TextFieldComponent
import com.haxon.funfacts.ui.TopBar
import com.haxon.funfacts.ui.UserInputViewModel

@Composable
fun UserInputScreen(userInputViewModel: UserInputViewModel, showWelcomeScreen: (Pair<String, String>) -> Unit) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(18.dp)
        ) {
            TopBar(UIS_TOP_BAR_HEADING)

            TextComponent(
                textValue = "Let's learn about You!",
                textSize = 24.sp
            )

            Spacer(modifier = Modifier.size(20.dp))

            TextComponent(
                textValue = "This app will prepare a details page based on input provided by you !",
                textSize = 18.sp
            )

            Spacer(modifier = Modifier.size(60.dp))

            TextComponent(textValue = "Name", textSize = 18.sp)
            Spacer(modifier = Modifier.size(10.dp))
            TextFieldComponent(onTextChanged = {
                userInputViewModel.onEvent(
                    event = UserDataUiEvents.UserNameEntered(it)
                )
            })

            Spacer(modifier = Modifier.size(20.dp))
            TextComponent(textValue = "What do you like", textSize = 18.sp)

            Row(modifier = Modifier.fillMaxWidth()) {
                AnimalCard(
                    image = R.drawable.cat,
                    animalSelected = {
                        userInputViewModel.onEvent(
                            UserDataUiEvents.AnimalSelected(it)
                        )
                    },
                    selected = userInputViewModel.uiState.value.animalEntered == "cat"
                )
                AnimalCard(
                    image = R.drawable.dog,
                    animalSelected = {
                        userInputViewModel.onEvent(
                            UserDataUiEvents.AnimalSelected(it)
                        )
                    },
                    selected = userInputViewModel.uiState.value.animalEntered == "dog"
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            if (userInputViewModel.isValidState()) {
                ButtonComponent {
                    showWelcomeScreen(
                        Pair(
                            userInputViewModel.uiState.value.nameEntered,
                            userInputViewModel.uiState.value.animalEntered
                        )
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun UserInputScreenPreview() {
    UserInputScreen(UserInputViewModel(), {})
}