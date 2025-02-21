package com.varqulabs.diproveboliviapp.core.presentation.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.varqulabs.diproveboliviapp.R

@Composable
fun DiprovePoliceBackgroundContainer(
    modifier: Modifier = Modifier,
    modifierImage: Modifier = Modifier,
    modifierContent: Modifier = Modifier,
    alpha: Float = 0.1f,
    color: Color = Color(0xFFF1F8E9),
    content: @Composable (Modifier) -> Unit,
) {
    Box(
        modifier = modifier.fillMaxSize().background(
            color = color
        ),
    ) {

        Image(
            modifier = modifierImage.padding(28.dp),
            contentScale = ContentScale.Fit,
            alpha = alpha,
            painter = painterResource(id = R.drawable.logo_diprove_bolivia),
            contentDescription = "Logo policia boliviana de fondo"
        )

        content(modifierContent.fillMaxSize())
    }
}