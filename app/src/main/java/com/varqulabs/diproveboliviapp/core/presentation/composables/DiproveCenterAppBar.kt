package com.varqulabs.diproveboliviapp.core.presentation.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.varqulabs.diproveboliviapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DiproveCenterAppBar(
    title: String,
    modifier: Modifier = Modifier,
    expandedHeight: Dp = 96.dp,
    colors: TopAppBarColors = TopAppBarDefaults.centerAlignedTopAppBarColors(
        containerColor = Color(0xFF167839)
    )
) {
    CenterAlignedTopAppBar(
        title = {
            if (title.isNotBlank()) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Center,
                    color = Color(0xFFFEFEFE)
                )
            }
        },
        actions = {
            Image(
                modifier = Modifier.size(72.dp),
                painter = painterResource(id = R.drawable.logo_policia_boliviana),
                contentDescription = "Logo Policia boliviana"
            )
        },
        navigationIcon = {
            Image(
                modifier = Modifier.size(72.dp),
                painter = painterResource(id = R.drawable.logo_diprove_bolivia),
                contentDescription = "Logo diprove"
            )
        },
        expandedHeight = expandedHeight,
        colors = colors,
        modifier = modifier
            .clip(
                RoundedCornerShape(
                    bottomStart = 24.dp,
                    bottomEnd = 24.dp
                )
            )

    )
}