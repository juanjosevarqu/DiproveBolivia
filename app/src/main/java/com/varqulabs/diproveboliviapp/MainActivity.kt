package com.varqulabs.diproveboliviapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.varqulabs.diproveboliviapp.core.presentation.composables.DiproveCenterAppBar
import com.varqulabs.diproveboliviapp.core.presentation.composables.DiprovePoliceBackgroundContainer
import com.varqulabs.diproveboliviapp.core.presentation.composables.SocialFloatingActionButtons
import com.varqulabs.diproveboliviapp.navigation.AppNavGraph
import com.varqulabs.diproveboliviapp.navigation.utils.getRoute
import com.varqulabs.diproveboliviapp.ui.theme.DiproveBoliviappTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val splashsScreen = installSplashScreen()
        splashsScreen.setKeepOnScreenCondition { true }
        CoroutineScope(Dispatchers.Main).launch {
            delay(500L)
            splashsScreen.setKeepOnScreenCondition { false }
        }

        setContent {
            DiproveBoliviappTheme {

                val navController = rememberNavController()
                val navBackStackEntry by navController.currentBackStackEntryAsState()

                val currentDestination = navBackStackEntry?.destination
                val currentTitleRes by remember(currentDestination) {
                    derivedStateOf { currentDestination.getRoute()?.title ?: R.string.copy_diprove_cbba }
                }

                Scaffold(
                    floatingActionButton = { SocialFloatingActionButtons() },
                    topBar = { DiproveCenterAppBar(title = stringResource(currentTitleRes)) },
                ) { paddingValues ->
                    DiprovePoliceBackgroundContainer(
                        modifierImage = Modifier
                            .padding(paddingValues)
                            .fillMaxSize()
                    ) {
                        AppNavGraph(
                            modifier = it.padding(paddingValues),
                            navController = navController
                        )
                    }
                }
            }
        }
    }
}
