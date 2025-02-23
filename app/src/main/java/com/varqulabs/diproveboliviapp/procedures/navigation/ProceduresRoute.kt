package com.varqulabs.diproveboliviapp.procedures.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.varqulabs.diproveboliviapp.navigation.Routes
import com.varqulabs.diproveboliviapp.procedures.presentation.ProceduresScreen

fun NavGraphBuilder.proceduresRoute(

) {
    composable<Routes.Procedures> {
        ProceduresScreen()
    }
}