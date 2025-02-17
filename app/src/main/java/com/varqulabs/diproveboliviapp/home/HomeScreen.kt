package com.varqulabs.diproveboliviapp.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.varqulabs.diproveboliviapp.R
import com.varqulabs.diproveboliviapp.core.presentation.composables.DiproveFunctionItem
import kotlinx.coroutines.delay

private val imagesCarruselDiprove = listOf(
    R.drawable.carrusel_diprove_1,
    R.drawable.carrusel_diprove_2,
    R.drawable.carrusel_diprove_3,
    R.drawable.carrusel_diprove_4,
    R.drawable.carrusel_diprove_5,
    R.drawable.carrusel_diprove_6,
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(

) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                modifier = Modifier,
                title = {
                    Text(
                        text = "Diprove CBBA",
                        style = MaterialTheme.typography.titleLarge,
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                    )
                },
                navigationIcon = {
                    Image(
                        modifier = Modifier.size(92.dp),
                        painter = painterResource(id = R.drawable.logo_diprove_bolivia),
                        contentDescription = "Logo diprove"
                    )
                },
                actions = {
                    Image(
                        modifier = Modifier.size(92.dp),
                        painter = painterResource(id = R.drawable.logo_policia_boliviana),
                        contentDescription = "Logo Policia boliviana"
                    )
                },
                expandedHeight = 112.dp
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 24.dp),
            contentPadding = PaddingValues(
                top = paddingValues.calculateTopPadding(),
                bottom = paddingValues.calculateBottomPadding() + 12.dp,
                start = 12.dp,
                end = 12.dp
            ),
            verticalArrangement = Arrangement.spacedBy(28.dp),
        ) {

            item {
                Text(
                    text = "Bienvenido!",
                    fontSize = 18.sp,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Medium,
                    fontStyle = FontStyle.Italic,
                    maxLines = 1,
                )
            }

            item {
                DiproveCarruselPager(
                    modifier = Modifier.fillMaxWidth()
                )
            }

            item {
                DiproveMisionVisionFunction(
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

@Composable
private fun DiproveCarruselPager(
    modifier: Modifier = Modifier
) {

    val pagerState = rememberPagerState { 6 }

    LaunchedEffect(pagerState.currentPage) {
        delay(1800L)
        pagerState.scrollToPage((pagerState.currentPage + 1) % imagesCarruselDiprove.size)
    }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp)),
            pageSize = PageSize.Fill,
            contentPadding = PaddingValues(0.dp),
            pageSpacing = 8.dp
        ) { index ->
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .aspectRatio(16 / 9f),
                contentScale = ContentScale.Crop,
                painter = painterResource(id = imagesCarruselDiprove[index]),
                contentDescription = "Imagen carrusel"
            )
        }

        Row(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth(),
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

@Composable
private fun DiproveMisionVisionFunction(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {

        DiproveFunctionItem(
            modifier = Modifier.fillMaxWidth(),
            headingText = "Misión:",
            bodyText = R.string.copy_diprove_mission
        )

        DiproveFunctionItem(
            modifier = Modifier.fillMaxWidth(),
            headingText = "Visión:",
            bodyText = R.string.copy_diprove_vision
        )

        DiproveFunctionItem(
            modifier = Modifier.fillMaxWidth(),
            headingText = "Funciones:",
            bodyText = R.string.copy_diprove_function
        )
    }
}