package com.varqulabs.diproveboliviapp.core.presentation.composables

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.varqulabs.diproveboliviapp.ui.theme.BricolageGrotesqueSemiCondensed

@Composable
fun PulsatingText(
    text: String,
    modifier: Modifier = Modifier,
    pulseRange: ClosedFloatingPointRange<Float> = 1.0f..1.1f,
    durationMillis: Int = 1000,
    style: TextStyle = TextStyle(
        fontFamily = BricolageGrotesqueSemiCondensed,
        fontSize = 18.sp,
        fontWeight = FontWeight.SemiBold
    )
) {

    val infiniteTransition = rememberInfiniteTransition()

    val scale by infiniteTransition.animateFloat(
        initialValue = pulseRange.start,
        targetValue = pulseRange.endInclusive,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        )
    )
    Text(
        text = text,
        style = style,
        modifier = modifier.graphicsLayer {
            scaleX = scale
            scaleY = scale
            transformOrigin = TransformOrigin.Center
        },
    )
}