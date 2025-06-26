package com.varqulabs.diproveboliviapp.welcome.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.varqulabs.diproveboliviapp.core.domain.DIPROVE_CBBA_WHATSAPP
import com.varqulabs.diproveboliviapp.core.presentation.utils.context.launchWhatsApp
import com.varqulabs.diproveboliviapp.ui.theme.BricolageGrotesqueSemiCondensed

@Composable
fun EmergencyButton(
    modifier: Modifier = Modifier
) {

    val context = LocalContext.current

    Button(
        onClick = {
            context.launchWhatsApp(
                phone = DIPROVE_CBBA_WHATSAPP,
                message = "Hola, Diprove CBBA, necesito ayuda con el siguiente caso: \n- "
            )
        },
        modifier = modifier,
        border = BorderStroke(
            width = 2.dp,
            color = Color(0xFFE53935)
        ),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFE57373),
            contentColor = Color(0xFFE9E7A9),
        ),
        shape = CircleShape
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            Text(
                text = "Botón de Emergencia",
                style = TextStyle(
                    fontFamily = BricolageGrotesqueSemiCondensed,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            )

            Icon(
                imageVector = Icons.Default.Phone,
                contentDescription = "Ir al inicio",
            )
        }
    }
}