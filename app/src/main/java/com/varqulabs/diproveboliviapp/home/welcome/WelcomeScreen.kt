package com.varqulabs.diproveboliviapp.home.welcome

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.varqulabs.diproveboliviapp.core.presentation.composables.DiproveCenterAppBar
import com.varqulabs.diproveboliviapp.core.presentation.composables.DiprovePoliceBackgroundContainer
import com.varqulabs.diproveboliviapp.home.welcome.components.DiproveCarruselPager

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WelcomeScreen(
    onClickStart: () -> Unit
) {
    Scaffold(
        topBar = {
            DiproveCenterAppBar(
                title = "DIPROVE COCHABAMBA",
            )
        },
        containerColor = Color(0xFFFEFEFE)
    ) { paddingValues ->
        DiprovePoliceBackgroundContainer(
            modifierImage = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Column(
                modifier = it.padding(
                    top = paddingValues.calculateTopPadding() + 24.dp,
                    bottom = paddingValues.calculateBottomPadding() + 12.dp,
                    start = 12.dp,
                    end = 12.dp
                ),
                verticalArrangement = Arrangement.spacedBy(28.dp, Alignment.CenterVertically),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "¡Bienvenido!",
                    fontSize = 18.sp,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Medium,
                    fontStyle = FontStyle.Italic,
                    maxLines = 1,
                )

                DiproveCarruselPager(
                    modifier = Modifier.fillMaxWidth()
                )

                Button(
                    onClick = onClickStart,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF177437),
                        contentColor = Color.White,
                    )
                ) {
                    Text(
                        text = "Ir al inicio"
                    )
                }
            }
        }
    }
}