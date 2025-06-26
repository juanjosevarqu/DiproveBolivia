package com.varqulabs.diproveboliviapp.welcome.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.varqulabs.diproveboliviapp.navigation.Routes
import com.varqulabs.diproveboliviapp.welcome.presentation.WelcomeScreen

fun NavGraphBuilder.welcomeRoute(
    onClickStart: () -> Unit,
) {
    composable<Routes.Welcome> {
        WelcomeScreen(
            onClickStart = onClickStart
        )
    }
}