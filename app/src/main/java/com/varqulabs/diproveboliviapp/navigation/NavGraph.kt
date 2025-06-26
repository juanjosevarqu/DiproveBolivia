package com.varqulabs.diproveboliviapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.varqulabs.diproveboliviapp.divisions.navigation.divisionsRoute
import com.varqulabs.diproveboliviapp.home.navigation.homeRoute
import com.varqulabs.diproveboliviapp.locations.navigation.locationsRoute
import com.varqulabs.diproveboliviapp.navigation.utils.enterZoomIn
import com.varqulabs.diproveboliviapp.navigation.utils.exitZoomOut
import com.varqulabs.diproveboliviapp.navigation.utils.navigateBack
import com.varqulabs.diproveboliviapp.navigation.utils.navigateTo
import com.varqulabs.diproveboliviapp.navigation.utils.popEnterZoomIn
import com.varqulabs.diproveboliviapp.navigation.utils.popExitZoomOut
import com.varqulabs.diproveboliviapp.procedures.navigation.proceduresRoute
import com.varqulabs.diproveboliviapp.suggestions.navigation.suggestionsRoute
import com.varqulabs.diproveboliviapp.welcome.navigation.welcomeRoute

@Composable
fun AppNavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Routes.Welcome,
        enterTransition = { enterZoomIn() },
        exitTransition = { exitZoomOut() },
        popEnterTransition = { popEnterZoomIn() },
        popExitTransition = { popExitZoomOut() },
    ) {

        welcomeRoute(
            onClickStart = { navController.navigateTo(Routes.Home) }
        )

        homeRoute(
            onClickRouteItem = { navController.navigateTo(it) }
        )

        divisionsRoute(
            onClickDivision = { divisionId ->
                navController.navigateTo(Routes.Divisions_Detail(divisionId))
            },
            onBack = { navController.navigateBack() }
        )

        locationsRoute()

        suggestionsRoute()

        proceduresRoute()

    }
}
