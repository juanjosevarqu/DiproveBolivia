package com.varqulabs.diproveboliviapp.navigation.utils

import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import com.varqulabs.diproveboliviapp.navigation.Routes

fun NavDestination?.getRoute(): Routes? {
    return this?.let {
        when {
            this.hasRoute<Routes.Welcome>() -> Routes.Welcome
            this.hasRoute<Routes.Home>() -> Routes.Home
            this.hasRoute<Routes.Locations>() -> Routes.Locations
            this.hasRoute<Routes.Procedures>() -> Routes.Procedures
            this.hasRoute<Routes.Suggestions>() -> Routes.Suggestions
            this.hasRoute<Routes.Divisions_Home>() -> Routes.Divisions_Home
            this.hasRoute<Routes.Divisions_Detail>() -> Routes.Divisions_Detail(1)
            else -> null
        }
    }
}