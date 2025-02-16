package com.varqulabs.diproveboliviapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.varqulabs.diproveboliviapp.core.domain.DIPROVE_CBBA_WHATSAPP
import com.varqulabs.diproveboliviapp.core.presentation.utils.context.launchWhatsApp
import com.varqulabs.diproveboliviapp.navigation.AppBottomNavigation
import com.varqulabs.diproveboliviapp.navigation.AppNavGraph
import com.varqulabs.diproveboliviapp.ui.theme.DiproveBoliviappTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DiproveBoliviappTheme {

                val context = LocalContext.current
                val navController = rememberNavController()

                var expandedFAB by remember { mutableStateOf(false) }

                Scaffold(
                    bottomBar = {
                        AppBottomNavigation(navController = navController)
                    },
                    floatingActionButton = {
                        ExtendedFloatingActionButton(
                            expanded = expandedFAB,
                            text = {
                                Text(
                                    text = "Diprove",
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.SemiBold
                                )
                            },
                            icon = {
                                Icon(
                                    imageVector = ImageVector.vectorResource(R.drawable.wa_logo),
                                    contentDescription = "WhatsApp Diprove",
                                    modifier = Modifier.size(32.dp)
                                )
                            },
                            onClick = {
                                if (expandedFAB) {
                                    expandedFAB = false
                                    context.launchWhatsApp(
                                        phone = DIPROVE_CBBA_WHATSAPP,
                                        message = "Hola, Diprove CBBA, necesito ayuda con el siguiente caso: \n- "
                                    )
                                } else {
                                    expandedFAB = true
                                }
                            },
                            containerColor = Color(0xFF266748),
                            contentColor = Color.White,
                        )
                    }
                ) { innerPadding ->
                    AppNavGraph(
                        navController = navController,
                        modifier = Modifier
                            .padding(
                                bottom = innerPadding.calculateBottomPadding(),
                            )
                            .fillMaxSize()
                    )
                }
            }
        }
    }
}