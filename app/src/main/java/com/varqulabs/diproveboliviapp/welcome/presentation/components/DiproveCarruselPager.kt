package com.varqulabs.diproveboliviapp.welcome.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.varqulabs.diproveboliviapp.R
import kotlinx.coroutines.delay

@Composable
fun DiproveCarruselPager(
    modifier: Modifier = Modifier
) {

    val pagerState = rememberPagerState { 6 }

    LaunchedEffect(pagerState.currentPage) {
        delay(1800L)
        pagerState.scrollToPage((pagerState.currentPage + 1) % imagesCarruselDiprove.size)
    }

    Box(
        modifier = modifier,
    ) {

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp))
                .border(
                    width = 2.dp,
                    color = Color(0xFFD0A82D),
                    shape = RoundedCornerShape(12.dp)
                ),
            pageSize = PageSize.Fill,
            contentPadding = PaddingValues(0.dp),
            pageSpacing = 8.dp
        ) { index ->
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .aspectRatio(10/16f),
                contentScale = ContentScale.Crop,
                painter = painterResource(id = imagesCarruselDiprove[index]),
                contentDescription = "Imagen carrusel"
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(bottom = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterHorizontally),
        ) {
            repeat(imagesCarruselDiprove.size) { iteration ->
                val color = if (pagerState.currentPage == iteration) Color.DarkGray else Color.LightGray
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(color)
                        .size(7.dp)
                )
            }
        }
    }
}

private val imagesCarruselDiprove = listOf(
    R.drawable.carrusel_diprove_1,
    R.drawable.carrusel_diprove_2,
    R.drawable.carrusel_diprove_3,
    R.drawable.carrusel_diprove_4,
    R.drawable.carrusel_diprove_5,
    R.drawable.carrusel_diprove_6,
)