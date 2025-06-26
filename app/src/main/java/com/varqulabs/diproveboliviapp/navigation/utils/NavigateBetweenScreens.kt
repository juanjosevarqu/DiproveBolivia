package com.varqulabs.diproveboliviapp.navigation.utils

import androidx.navigation.NavHostController
import com.varqulabs.diproveboliviapp.navigation.Routes

fun NavHostController.navigateTo(route: Routes) {
    navigate(route) {
        launchSingleTop = true
        restoreState = true
    }
}