package com.varqulabs.diproveboliviapp.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.varqulabs.diproveboliviapp.R
import com.varqulabs.diproveboliviapp.core.presentation.composables.DiproveCenterAppBar
import com.varqulabs.diproveboliviapp.core.presentation.composables.DiproveDescriptionItem
import com.varqulabs.diproveboliviapp.divisions.presentation.home.DivisionsHomeScaffold
import com.varqulabs.diproveboliviapp.home.home.HomeScreen
import com.varqulabs.diproveboliviapp.home.welcome.WelcomeScreen
import com.varqulabs.diproveboliviapp.locations.presentation.RegionalLocationsScreen
import com.varqulabs.diproveboliviapp.procedures.presentation.ProceduresScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = WelcomeScreen,
        modifier = modifier,
    ) {

        composable<WelcomeScreen> {
            WelcomeScreen(
                onClickStart = { navController.navigate(HomeScreen) }
            )
        }

        composable<HomeScreen> {
            HomeScreen(
                onClickRouteItem = { navController.navigate(it) }
            )
        }

        composable<LocationsRoute> {
            RegionalLocationsScreen()
        }

        composable<ProceduresRoute> {
            ProceduresScreen()
        }

        composable<DivisionsRoute> {
            DivisionsHomeScaffold()
        }

        composable<SuggestionsRoute> {
            Scaffold(
                topBar = {
                    DiproveCenterAppBar(
                        title = stringResource(R.string.copy_diprove_suggestions),
                    )
                },
                containerColor = Color(0xFFFEFEFE)
            ) { paddingValues ->
                Column(
                    modifier = Modifier
                        .padding(
                            top = paddingValues.calculateTopPadding() + 12.dp,
                            start = 16.dp,
                            end = 16.dp
                        )
                        .fillMaxWidth()
                        .verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.Center
                ) {
                    repeat(3) {
                        DiproveDescriptionItem(
                            modifier = Modifier.fillMaxWidth(),
                            headingText = "Recomedacion: ${it + 1}",
                            bodyText = R.string.copy_diprove_regional_suggestion
                        )
                    }
                }
            }
        }
    }
}

/*
fun NavHostController.navigateToSingleTop(route: Routes) {
    navigate(route) {
        popUpTo(graph.id) { saveState = true }
        launchSingleTop = true
        restoreState = true
    }
}*/
