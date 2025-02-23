package com.varqulabs.diproveboliviapp.locations.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.varqulabs.diproveboliviapp.locations.presentation.RegionalLocationsScreen
import com.varqulabs.diproveboliviapp.navigation.Routes

fun NavGraphBuilder.locationsRoute(

) {
    composable<Routes.Locations> {
        RegionalLocationsScreen()
    }
}