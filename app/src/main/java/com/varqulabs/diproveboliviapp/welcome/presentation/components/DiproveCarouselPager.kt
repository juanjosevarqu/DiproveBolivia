package com.varqulabs.diproveboliviapp.welcome.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.varqulabs.diproveboliviapp.core.presentation.composables.CarouselContent

@Composable
fun DiproveCarouselPager(
    modifier: Modifier = Modifier,
    images: List<Int>,
    aspectRatio: Float = 16 / 9f,
) {
    CarouselContent(
        modifier = modifier,
        list = images,
        widthItem = 300.dp,
        aspectRatio = aspectRatio,
        infiniteLoop = true,
        alignToCenter = true,
    ) { contentModifier, page ->
        Image(
            modifier = contentModifier.clip(RoundedCornerShape(12.dp)),
            contentScale = ContentScale.Crop,
            painter = painterResource(id = images[page]),
            contentDescription = "Imagen carrusel $page"
        )
    }
}