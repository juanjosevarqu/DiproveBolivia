package com.varqulabs.diproveboliviapp

import android.content.Context
import android.os.Bundle
import android.util.DisplayMetrics
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
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.varqulabs.diproveboliviapp.core.presentation.composables.DiproveCenterAppBar
import com.varqulabs.diproveboliviapp.core.presentation.composables.DiprovePoliceBackgroundContainer
import com.varqulabs.diproveboliviapp.core.presentation.composables.SocialFloatingActionButtons
import com.varqulabs.diproveboliviapp.navigation.AppNavGraph
import com.varqulabs.diproveboliviapp.navigation.Routes
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
                    floatingActionButton = if (currentDestination?.hasRoute<Routes.Welcome>() == true) {
                        {  }
                    } else {
                        { SocialFloatingActionButtons() }
                    },
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

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(newBase?.limitFontScale())
    }
}

const val MAX_FONT_SCALE = 1.10F
const val MAX_DPI_SCALE = 1.00F

fun Context.limitFontScale(
    maxFontScale: Float = MAX_FONT_SCALE,
    maxDpiScale: Float = MAX_DPI_SCALE,
): Context {
    val configuration = resources.configuration
    val defaultDeviceDensity = DisplayMetrics.DENSITY_DEVICE_STABLE
    val maximumDpiScale = (defaultDeviceDensity * maxDpiScale).toInt()

    val exceedsFontScale = configuration.fontScale > maxFontScale
    val exceedsDpiScale = configuration.densityDpi < DisplayMetrics.DENSITY_560 && configuration.densityDpi > maximumDpiScale

    configuration.apply {
        if (exceedsFontScale) { fontScale = maxFontScale }
        if (exceedsDpiScale) { densityDpi = maximumDpiScale }
    }

    return if (exceedsFontScale || exceedsDpiScale) createConfigurationContext(configuration)
    else this
}
