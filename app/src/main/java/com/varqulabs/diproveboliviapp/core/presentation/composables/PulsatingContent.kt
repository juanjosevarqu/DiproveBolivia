package com.varqulabs.diproveboliviapp.core.presentation.composables

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer

@Composable
fun PulsatingContent(
    pulseRange: ClosedFloatingPointRange<Float> = 1.0f..1.1f,
    durationMillis: Int = 1000,
    content: @Composable (Modifier) -> Unit
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

    content(
        Modifier.graphicsLayer {
            scaleX = scale
            scaleY = scale
            transformOrigin = TransformOrigin.Center
        }
    )
}