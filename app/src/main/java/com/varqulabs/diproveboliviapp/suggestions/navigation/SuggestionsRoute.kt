package com.varqulabs.diproveboliviapp.suggestions.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.varqulabs.diproveboliviapp.navigation.Routes
import com.varqulabs.diproveboliviapp.suggestions.presentation.SuggestionsDiproveCarousel

fun NavGraphBuilder.suggestionsRoute(

) {
    composable<Routes.Suggestions> {
        SuggestionsDiproveCarousel(modifier = Modifier.fillMaxSize())
    }
}

