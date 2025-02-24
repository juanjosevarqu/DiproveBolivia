package com.varqulabs.diproveboliviapp.core.presentation.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.varqulabs.diproveboliviapp.core.presentation.utils.modifier.carouselTransition
import kotlinx.coroutines.delay

@Composable
fun <T> CarouselContent(
    modifier: Modifier = Modifier,
    list: List<T>,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    pageSize: PageSize = PageSize.Fill,
    infiniteLoop: Boolean = false,
    widthItem: Dp = 300.dp,
    aspectRatio: Float = 3 / 4f,
    alignToCenter: Boolean = true,
    content: @Composable (contentModifier: Modifier, page: Int) -> Unit,
) {

    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val defaultPageCount by remember(list) {
        derivedStateOf { if (infiniteLoop) if (list.size % 2 == 0) (Int.MAX_VALUE / 2) + 1 else (Int.MAX_VALUE - 1) / 2 else 0 }
    }
    val pagerState = rememberPagerState(initialPage = defaultPageCount) { if (infiniteLoop) Int.MAX_VALUE else list.size }
    val customContentPadding = remember { PaddingValues(horizontal = ((screenWidth - widthItem) / 2)) }

    LaunchedEffect(pagerState.currentPage) {
        delay(2500L)
        pagerState.scrollToPage((pagerState.currentPage + 1))
    }

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxWidth(),
            pageSpacing = 16.dp,
            contentPadding = if (alignToCenter) customContentPadding else contentPadding,
            pageSize = pageSize,
        ) { page ->
            content(
                Modifier
                    .width(widthItem)
                    .aspectRatio(aspectRatio)
                    .carouselTransition(page, pagerState),
                if (infiniteLoop) page % list.size else page,
            )
        }
    }
}