package com.haxon.funfacts.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.haxon.funfacts.ui.FactComposable
import com.haxon.funfacts.ui.FactsViewModel
import com.haxon.funfacts.ui.TextComponent
import com.haxon.funfacts.ui.TopBar
import com.haxon.funfacts.ui.TextWithShadow

@Composable
fun WelcomeScreen(username: String?, animalSelected: String?) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(18.dp)
        ) {
            val heading = "Welcome $username \uD83D\uDE0D"
            TopBar(topBarText = heading)

            TextComponent(
                textValue = "Thank You! for sharing your data",
                textSize = 24.sp
            )

            Spacer(modifier = Modifier.size(60.dp))

            val selectedAnimalString = if (animalSelected == "cat")
                "You are a Cat lover \uD83D\uDC08"
            else
                "You are a Dog lover \uD83D\uDC36"

            TextWithShadow(value = selectedAnimalString)

            val factsViewModel: FactsViewModel = viewModel()
            FactComposable(value = factsViewModel.generateRandomFacts(animalSelected!!))

        }
    }
}

@Preview
@Composable
fun WelcomeScreenPreview() {
    WelcomeScreen("username", "animalSelected")
}