package com.varqulabs.diproveboliviapp.suggestions.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.varqulabs.diproveboliviapp.navigation.Routes
import com.varqulabs.diproveboliviapp.suggestions.presentation.SuggestionsScreen

fun NavGraphBuilder.suggestionsRoute(

) {
    composable<Routes.Suggestions> {
        SuggestionsScreen()
    }
}

