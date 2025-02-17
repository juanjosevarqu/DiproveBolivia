package com.varqulabs.diproveboliviapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.varqulabs.diproveboliviapp.home.HomeScreen
import com.varqulabs.diproveboliviapp.institution.presentation.AboutInstitutionScreen
import com.varqulabs.diproveboliviapp.locations.presentation.RegionalLocationsScreen
import com.varqulabs.diproveboliviapp.procedures.presentation.ProceduresScreen

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

            )
        }

        composable<LocationsRoute> {
            RegionalLocationsScreen(

            )
        }

        composable<ProceduresRoute> {
            ProceduresScreen(

            )
        }

        composable<AboutInstitutionRoute> {
            AboutInstitutionScreen(

            )
        }

        composable<AboutAppRoute> {

        }
    }
}