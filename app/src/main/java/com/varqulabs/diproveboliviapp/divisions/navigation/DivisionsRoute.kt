package com.varqulabs.diproveboliviapp.divisions.navigation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.varqulabs.diproveboliviapp.divisions.presentation.detail.DiproveDivisionInfoScreen
import com.varqulabs.diproveboliviapp.divisions.presentation.home.DiproveDivisionsSelector
import com.varqulabs.diproveboliviapp.domain.DiproveDivision
import com.varqulabs.diproveboliviapp.domain.diproveDivisionsMap
import com.varqulabs.diproveboliviapp.navigation.Routes

fun NavGraphBuilder.divisionsRoute(
    onClickDivision: (divisionId: Int) -> Unit,
    onBack: () -> Unit,
) {

    composable<Routes.Divisions_Home> {
        DiproveDivisionsSelector(
            modifier = Modifier.fillMaxWidth(),
            onClickDivision = onClickDivision,
        )
    }

    composable<Routes.Divisions_Detail> { backStackEntry ->

        val divisionId = backStackEntry.toRoute<Routes.Divisions_Detail>().divisionId
        val division = diproveDivisionsMap[divisionId] ?: DiproveDivision()

        DiproveDivisionInfoScreen(
            modifier = Modifier.fillMaxWidth(),
            diproveDivision = division,
            onBack = onBack,
        )
    }
}