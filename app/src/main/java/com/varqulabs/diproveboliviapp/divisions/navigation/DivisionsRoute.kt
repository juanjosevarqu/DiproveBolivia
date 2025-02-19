package com.varqulabs.diproveboliviapp.divisions.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.varqulabs.diproveboliviapp.divisions.presentation.home.DivisionsHomeScaffold
import com.varqulabs.diproveboliviapp.navigation.DivisionsRoute

fun NavGraphBuilder.divisionsRoute(

) {
    composable<DivisionsRoute> {
        DivisionsHomeScaffold()
    }
}