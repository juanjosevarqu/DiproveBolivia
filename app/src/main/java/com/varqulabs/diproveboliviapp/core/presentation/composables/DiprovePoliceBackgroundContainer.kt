package com.varqulabs.diproveboliviapp.core.presentation.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
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
            modifier = modifierImage.padding(48.dp),
            contentScale = ContentScale.Fit,
            alpha = 0.1f,
            painter = painterResource(id = R.drawable.logo_policia_boliviana),
            contentDescription = "Logo policia boliviana de fondo"
        )

        content(modifierContent.fillMaxSize())
    }
}