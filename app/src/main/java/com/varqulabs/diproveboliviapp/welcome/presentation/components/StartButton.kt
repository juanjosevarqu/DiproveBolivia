package com.varqulabs.diproveboliviapp.welcome.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.varqulabs.diproveboliviapp.core.presentation.composables.PulsatingContent
import com.varqulabs.diproveboliviapp.ui.theme.BricolageGrotesqueSemiCondensed

@Composable
fun StartButton(
    onClickStart: () -> Unit
) {
    PulsatingContent(
        pulseRange = 1.0f..1.15f,
    ) {
        Button(
            onClick = onClickStart,
            modifier = it,
            border = BorderStroke(
                width = 2.dp,
                color = Color(0xFFAB8E32)
            ),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFF4F2B1),
                contentColor = Color(0xFFAB8E32),
            ),
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