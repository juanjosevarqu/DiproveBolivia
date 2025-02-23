package com.varqulabs.diproveboliviapp.home.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.varqulabs.diproveboliviapp.home.home.HomeScreen
import com.varqulabs.diproveboliviapp.navigation.Routes

fun NavGraphBuilder.homeRoute(
    onClickRouteItem: (Routes) -> Unit,
) {
    composable<Routes.Home> {
        HomeScreen(
            onClickRouteItem = onClickRouteItem
        )
    }
}