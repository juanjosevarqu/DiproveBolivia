package com.varqulabs.diproveboliviapp.welcome.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.varqulabs.diproveboliviapp.core.presentation.composables.PulsatingButton
import com.varqulabs.diproveboliviapp.core.presentation.composables.PulsatingText
import com.varqulabs.diproveboliviapp.ui.theme.BricolageGrotesqueSemiCondensed
import com.varqulabs.diproveboliviapp.welcome.presentation.components.DiproveCarruselPager

@Composable
fun WelcomeScreen(
    onClickStart: () -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(
            top = 16.dp,
            start = 12.dp,
            end = 12.dp
        ),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {

                DiproveCarruselPager(
                    modifier = Modifier.fillMaxWidth()
                )

                PulsatingText(
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .padding(top = 24.dp),
                    text = "¡Bienvenido!",
                    style = TextStyle(
                        fontFamily = BricolageGrotesqueSemiCondensed,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFF388E3C)
                    )
                )

                PulsatingButton(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 48.dp),
                    onClick = onClickStart,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFF4F2B1),
                        contentColor = Color(0xFFAB8E32),
                    )
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {

                        Text(
                            text = "Comenzar",
                            style = TextStyle(
                                fontFamily = BricolageGrotesqueSemiCondensed,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                        )

                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                            contentDescription = "Ir al inicio",
                        )
                    }
                }
            }
        }
    }
}