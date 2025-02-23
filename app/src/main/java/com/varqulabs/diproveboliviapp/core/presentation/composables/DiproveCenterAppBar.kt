package com.varqulabs.diproveboliviapp.core.presentation.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.varqulabs.diproveboliviapp.R
import com.varqulabs.diproveboliviapp.ui.theme.BricolageGrotesqueSemiCondensed

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DiproveCenterAppBar(
    title: String,
    modifier: Modifier = Modifier,
    expandedHeight: Dp = 86.dp,
    colors: TopAppBarColors = TopAppBarDefaults.centerAlignedTopAppBarColors(
        containerColor = Color(0xFF167839)
    )
) {
    Surface(
        shape = RoundedCornerShape(bottomStartPercent = 25, bottomEndPercent = 25),
        color = Color.Black,
        shadowElevation = 12.dp,
        modifier = modifier
    ) {
        CenterAlignedTopAppBar(
            title = {
                if (title.isNotBlank()) {
                    Text(
                        text = title,
                        maxLines = 3,
                        overflow = TextOverflow.Ellipsis,
                        style = TextStyle(
                            fontSize = 22.sp,
                            fontFamily = BricolageGrotesqueSemiCondensed,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color(0xFFFEFEFE),
                            textAlign = TextAlign.Center,
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
            modifier = Modifier
                .fillMaxWidth()
                .clip(
                    RoundedCornerShape(
                        bottomEndPercent = 25,
                        bottomStartPercent = 25
                    )
                )
        )
    }
}