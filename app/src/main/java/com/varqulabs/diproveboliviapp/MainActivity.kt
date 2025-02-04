package com.varqulabs.diproveboliviapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.varqulabs.diproveboliviapp.navigation.AppBottomNavigation
import com.varqulabs.diproveboliviapp.navigation.AppNavGraph
import com.varqulabs.diproveboliviapp.ui.theme.DiproveBoliviappTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DiproveBoliviappTheme {

                val navController = rememberNavController()

                AppNavGraph(
                    navController = navController,
                    modifier = Modifier.fillMaxSize()
                )

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .systemBarsPadding(),
                    contentAlignment = Alignment.BottomCenter
                ) {
                    AppBottomNavigation(navController = navController)
                }
            }
        }
    }
}