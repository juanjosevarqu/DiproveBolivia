package com.varqulabs.diproveboliviapp.suggestions.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.Hyphens
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.varqulabs.diproveboliviapp.R
import com.varqulabs.diproveboliviapp.core.domain.diproveSuggestions
import com.varqulabs.diproveboliviapp.core.presentation.composables.CarouselContent
import com.varqulabs.diproveboliviapp.core.presentation.composables.DiproveDescriptionItem
import com.varqulabs.diproveboliviapp.ui.theme.BricolageGrotesque

@Composable
fun SuggestionsDiproveCarousel(
    modifier: Modifier = Modifier
) {
    CarouselContent(
        modifier = modifier,
        pageSize = PageSize.Fixed(315.dp),
        list = diproveSuggestions,
        widthItem = 315.dp,
        aspectRatio = 9 / 18f,
        infiniteLoop = false,
        alignToCenter = true,
        autoScroll = false,
        pageSpacing = 0.dp,
    ) { contentModifier, page ->
        Box(
            modifier = contentModifier.fillMaxSize()
        ) {

            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(R.drawable.pergamino_sin_logo),
                contentDescription = "Pergamino",
                alpha = 0.8f,
                contentScale = ContentScale.FillBounds,
            )

            Image(
                modifier = Modifier
                    .padding(top = 64.dp, end = 24.dp)
                    .size(100.dp)
                    .align(Alignment.TopEnd),
                painter = painterResource(R.drawable.logo_diprove_bolivia),
                contentDescription = "Logo Diprove",
                alpha = 0.8f,
            )

            DiproveDescriptionItem(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = 180.dp,
                        start = 36.dp,
                        end = 36.dp,
                        bottom = 52.dp
                    )
                    .verticalScroll(rememberScrollState()),
                headingText = stringResource(diproveSuggestions[page].first),
                bodyText = diproveSuggestions[page].second,
                bodyStyle = TextStyle(
                    textAlign = TextAlign.Justify,
                    hyphens = Hyphens.Auto,
                    fontSize = 15.sp,
                    lineHeight = 26.sp,
                    fontFamily = BricolageGrotesque,
                    fontWeight = FontWeight.Medium,
                    color = Color.DarkGray
                ),
                headingStyle = TextStyle(
                    fontSize = 20.sp,
                    fontFamily = BricolageGrotesque,
                    fontWeight = FontWeight.SemiBold,
                    textDecoration = TextDecoration.Underline
                ),
            )
        }
    }
}