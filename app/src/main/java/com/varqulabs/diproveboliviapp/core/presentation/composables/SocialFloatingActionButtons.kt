package com.varqulabs.diproveboliviapp.core.presentation.composables

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.varqulabs.diproveboliviapp.R
import com.varqulabs.diproveboliviapp.core.domain.DIPROVE_CBBA_WHATSAPP
import com.varqulabs.diproveboliviapp.core.presentation.utils.context.launchExternalIntent
import com.varqulabs.diproveboliviapp.core.presentation.utils.context.launchWhatsApp
import com.varqulabs.diproveboliviapp.core.presentation.utils.modifier.clickableSingle
import kotlinx.coroutines.delay

@Composable
fun SocialFloatingActionButtons() {

    val context = LocalContext.current
    var expanded by remember { mutableStateOf(false) }

    LaunchedEffect(expanded) {
        if (expanded) {
            delay(3000)
            expanded = false
        }
    }

    Column(
        horizontalAlignment = Alignment.End,
    ) {
        AnimatedVisibility(
            visible = expanded,
            enter = fadeIn() + slideInVertically(initialOffsetY = { it }) + expandVertically(),
            exit = fadeOut() + slideOutVertically(targetOffsetY = { it }) + shrinkVertically()
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.facebook_logo),
                contentDescription = "Facebook Diprove",
                tint = Color(0xFF1B73E8),
                modifier = Modifier
                    .padding(bottom = 12.dp)
                    .size(42.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFFFFFFF))
                    .clickableSingle {
                        expanded = false
                        context.launchExternalIntent(
                            uri = "https://www.facebook.com/profile.php?id=100064333885924"
                        )
                    }
            )
        }

        ExtendedFloatingActionButton(
            expanded = expanded,
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
                if (expanded) {
                    expanded = false
                    context.launchWhatsApp(
                        phone = DIPROVE_CBBA_WHATSAPP,
                        message = "Hola, Diprove CBBA, necesito ayuda con el siguiente caso: \n- "
                    )
                } else {
                    expanded = true
                }
            },
            containerColor = Color(0xFF266748),
            contentColor = Color.White,
            shape = MaterialTheme.shapes.extraLarge
        )
    }
}