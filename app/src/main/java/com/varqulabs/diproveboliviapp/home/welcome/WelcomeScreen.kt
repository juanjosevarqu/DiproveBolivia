package com.varqulabs.diproveboliviapp.home.welcome

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.varqulabs.diproveboliviapp.core.presentation.composables.DiproveCenterAppBar
import com.varqulabs.diproveboliviapp.core.presentation.composables.DiprovePoliceBackgroundContainer
import com.varqulabs.diproveboliviapp.core.presentation.composables.PulsatingButton
import com.varqulabs.diproveboliviapp.home.welcome.components.DiproveCarruselPager
import com.varqulabs.diproveboliviapp.ui.theme.BricolageGrotesqueSemiCondensed

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
            LazyColumn(
                modifier = it,
                contentPadding = PaddingValues(
                    top = paddingValues.calculateTopPadding(),
                    start = 12.dp,
                    end = 12.dp
                ),
                verticalArrangement = Arrangement.spacedBy(28.dp, Alignment.CenterVertically),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                item {
                    DiproveCarruselPager(
                        modifier = Modifier.fillMaxWidth()
                    )
                }

                item {
                    Text(
                        text = "¡Bienvenido!",
                        maxLines = 1,
                        style = TextStyle(
                            fontFamily = BricolageGrotesqueSemiCondensed,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Medium
                        )
                    )
                }

                item {
                    PulsatingButton(
                        onClick = onClickStart,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFF4F2B1),
                            contentColor = Color(0xFFAB8E32),
                        )
                    ) {
                        Text(
                            text = "Ir al inicio",
                            style = TextStyle(
                                fontFamily = BricolageGrotesqueSemiCondensed,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                        )
                    }
                }
            }
        }
    }
}