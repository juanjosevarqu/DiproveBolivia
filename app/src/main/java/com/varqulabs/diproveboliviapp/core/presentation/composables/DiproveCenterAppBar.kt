package com.varqulabs.diproveboliviapp.core.presentation.composables

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.varqulabs.diproveboliviapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DiproveCenterAppBar(
    title: String,
    modifier: Modifier = Modifier,
    expandedHeight: Dp = 84.dp,
    colors: TopAppBarColors = TopAppBarDefaults.centerAlignedTopAppBarColors(
        containerColor = Color(0xFF167839)
    )
) {
    CenterAlignedTopAppBar(
        title = {
            if (title.isNotBlank()) {
                Text(
                    text = title,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFFEFEFE),
                        textAlign = TextAlign.Center,
                        letterSpacing = 2.sp
                    ),
                )
            }
        },
        navigationIcon = {
            PulsatingImage(
                modifier = Modifier.size(64.dp),
                image = R.drawable.logo_diprove_bolivia,
                contentDescription = "Logo diprove",
            )
        },
        actions = {
            PulsatingImage(
                modifier = Modifier.size(64.dp),
                image = R.drawable.logo_policia_boliviana,
                contentDescription = "Logo Policia boliviana",
            )
        },
        expandedHeight = expandedHeight,
        colors = colors,
        modifier = modifier
            .clip(
                RoundedCornerShape(
                    bottomEndPercent = 25,
                    bottomStartPercent = 25
                )
            )

    )
}