package com.varqulabs.diproveboliviapp.core.presentation.utils.modifier

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.ripple
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.debugInspectorInfo
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.util.lerp
import kotlinx.coroutines.delay
import kotlin.math.absoluteValue

fun Modifier.clickableSingle(
    enabled: Boolean = true,
    onClickLabel: String? = null,
    role: Role? = null,
    onClick: () -> Unit,
) = composed(
    inspectorInfo = debugInspectorInfo {
        name = "clickable"
        properties["enabled"] = enabled
        properties["onClickLabel"] = onClickLabel
        properties["role"] = role
        properties["onClick"] = onClick
    }
) {
    var isEnabled by remember { mutableStateOf(enabled) }
    val indication = ripple()
    LaunchedEffect(isEnabled) { if (!isEnabled) delay(500L); isEnabled = true }
    Modifier.clickable(
        enabled = isEnabled,
        onClickLabel = onClickLabel,
        onClick = { onClick(); isEnabled = false },
        role = role,
        indication = indication,
        interactionSource = remember { MutableInteractionSource() }
    )
}

fun Modifier.carouselTransition(
    page: Int,
    pagerState: PagerState,
): Modifier {
    val pageOffset = ((pagerState.currentPage - page) + pagerState.currentPageOffsetFraction).absoluteValue
    val transformation = lerp(
        start = .7f,
        stop = 1f,
        fraction = 1f - pageOffset.coerceIn(0f, 1f)
    )
    return this.graphicsLayer { alpha = transformation }
}