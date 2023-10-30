package com.haxon.funfacts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.haxon.funfacts.ui.screens.FunFactsNavigationGraph
import com.haxon.funfacts.ui.screens.Routes
import com.haxon.funfacts.ui.screens.UserInputScreen
import com.haxon.funfacts.ui.screens.WelcomeScreen
import com.haxon.funfacts.ui.theme.FunFactsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            FunFactsTheme {
                funFactsApp()
            }
        }
    }

    @Composable
    private fun funFactsApp() {
        FunFactsNavigationGraph()
    }
}