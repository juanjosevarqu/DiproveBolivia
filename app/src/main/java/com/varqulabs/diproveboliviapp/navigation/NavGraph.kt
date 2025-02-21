package com.varqulabs.diproveboliviapp.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import com.varqulabs.diproveboliviapp.core.presentation.composables.DiprovePoliceBackgroundContainer
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
                DiprovePoliceBackgroundContainer(
                    modifierImage = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                ) {
                    LazyColumn(
                        modifier = it,
                        contentPadding = PaddingValues(
                            top = paddingValues.calculateTopPadding() + 24.dp,
                            bottom = paddingValues.calculateBottomPadding() + 12.dp,
                            start = 24.dp,
                            end = 24.dp
                        ),
                        verticalArrangement = Arrangement.spacedBy(28.dp)
                    ) {
                        items(4) { number ->
                            DiproveDescriptionItem(
                                modifier = Modifier.fillMaxWidth(),
                                headingText = "Recomedacion ${number + 1}",
                                bodyText = R.string.copy_diprove_regional_suggestion_demo
                            )
                        }
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
