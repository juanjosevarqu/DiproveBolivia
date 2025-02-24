package com.varqulabs.diproveboliviapp.core.presentation.composables

import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.varqulabs.diproveboliviapp.core.presentation.utils.modifier.carouselTransition
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun <T> DiproveCarousel(
    modifier: Modifier = Modifier,
    list: List<T>,
    pageSize: PageSize = PageSize.Fill,
    autoScroll: Boolean = true,
    infiniteLoop: Boolean = false,
    aspectRatio: Float = 3 / 4f,
    pageSpacing: Dp = 16.dp,
    content: @Composable (contentModifier: Modifier, page: Int) -> Unit,
) {

    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState { if (infiniteLoop) Int.MAX_VALUE else list.size }

    LaunchedEffect(pagerState.currentPage) {
        if (autoScroll) {
            delay(1800L)
            scope.launch {
                pagerState.animateScrollToPage(
                    page = pagerState.currentPage + 1,
                    animationSpec = tween(1000)
                )
            }
        }
    }

    HorizontalPager(
        state = pagerState,
        modifier = modifier,
        pageSpacing = pageSpacing,
        pageSize = pageSize,
    ) { page ->
        content(
            Modifier
                .aspectRatio(aspectRatio)
                .carouselTransition(page, pagerState),
            if (infiniteLoop) page % list.size else page,
        )
    }
}