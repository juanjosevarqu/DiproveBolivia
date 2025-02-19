package com.varqulabs.diproveboliviapp.divisions.presentation.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import androidx.navigation.toRoute
import com.varqulabs.diproveboliviapp.R
import com.varqulabs.diproveboliviapp.core.presentation.composables.DiproveCenterAppBar
import com.varqulabs.diproveboliviapp.core.presentation.composables.DiprovePoliceBackgroundContainer
import com.varqulabs.diproveboliviapp.divisions.presentation.components.DiproveDivisionsSelector
import com.varqulabs.diproveboliviapp.divisions.presentation.detail.DiproveDivisionInfoScreen
import com.varqulabs.diproveboliviapp.domain.DiproveDivision
import com.varqulabs.diproveboliviapp.domain.diproveDivisionsMap
import com.varqulabs.diproveboliviapp.navigation.DiproveDivisionScreen
import com.varqulabs.diproveboliviapp.navigation.DivisionsHomeScreen
import com.varqulabs.diproveboliviapp.navigation.DivisionsRoute
import com.varqulabs.diproveboliviapp.navigation.utils.navigateBack

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DivisionsHomeScaffold(

) {
    Scaffold(
        topBar = {
            DiproveCenterAppBar(
                title = stringResource(R.string.copy_diprove_cbba_divisions),
            )
        },
        containerColor = Color(0xFFFEFEFE)
    ) { paddingValues ->
        DiprovePoliceBackgroundContainer(
            modifierImage = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {

            val navController = rememberNavController()

            NavHost(
                modifier = it.padding(paddingValues),
                navController = navController,
                startDestination = DivisionsRoute,
            ) {
                navigation<DivisionsRoute>(startDestination = DivisionsHomeScreen) {

                    composable<DivisionsHomeScreen> {
                        DiproveDivisionsSelector(
                            modifier = Modifier.fillMaxSize(),
                            onClickDivision = { divisionId ->
                                navController.navigate(DiproveDivisionScreen(divisionId)) {
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        ) 
                    }

                    composable<DiproveDivisionScreen> { backStackEntry ->

                        val divisionId = backStackEntry.toRoute<DiproveDivisionScreen>().divisionId
                        val division = diproveDivisionsMap[divisionId] ?: DiproveDivision()

                        DiproveDivisionInfoScreen(
                            modifier = Modifier.fillMaxWidth(),
                            diproveDivision = division,
                            onBack = { navController.navigateBack() },
                        )
                    }
                }
            }
        }
    }
}