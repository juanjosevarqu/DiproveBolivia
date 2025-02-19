package com.varqulabs.diproveboliviapp.core.presentation.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.varqulabs.diproveboliviapp.R

@Composable
fun DiprovePoliceBackgroundContainer(
    modifier: Modifier = Modifier,
    modifierImage: Modifier = Modifier,
    modifierContent: Modifier = Modifier,
    content: @Composable (Modifier) -> Unit,
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {

        Image(
            modifier = modifierImage,
            contentScale = ContentScale.Fit,
            alpha = 0.15f,
            painter = painterResource(id = R.drawable.logo_diprove_bolivia),
            contentDescription = "Logo policia boliviana de fondo"
        )

        content(modifierContent.fillMaxSize())
    }
}