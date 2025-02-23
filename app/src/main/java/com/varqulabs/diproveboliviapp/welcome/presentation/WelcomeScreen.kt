package com.varqulabs.diproveboliviapp.welcome.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ButtonDefaults
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
import com.varqulabs.diproveboliviapp.welcome.presentation.components.DiproveCarruselPager
import com.varqulabs.diproveboliviapp.ui.theme.BricolageGrotesqueSemiCondensed

@Composable
fun WelcomeScreen(
    onClickStart: () -> Unit
) {

    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(
            top = 36.dp,
            start = 12.dp,
            end = 12.dp
        ),
        verticalArrangement = Arrangement.spacedBy(24.dp),
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