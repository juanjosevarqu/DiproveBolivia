package com.varqulabs.diproveboliviapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.varqulabs.diproveboliviapp.home.HomeScreen

@Composable
fun AppNavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = HomeRoute,
        modifier = modifier,
    ) {

        composable<HomeRoute> {
            HomeScreen(
                provisionalName = BottomScreens.Home.name
            )
        }

        composable<LocationsRoute> {
            HomeScreen(
                provisionalName = BottomScreens.Locations.name
            )
        }

        composable<ProceduresRoute> {

            HomeScreen(
                provisionalName = BottomScreens.Procedures.name
            )
        }

        composable<AboutInstitutionRoute> {

            HomeScreen(
                provisionalName = BottomScreens.AboutInstitution.name
            )
        }

        composable<AboutAppRoute> {

            HomeScreen(
                provisionalName = "Mas info"
            )
        }
    }
}