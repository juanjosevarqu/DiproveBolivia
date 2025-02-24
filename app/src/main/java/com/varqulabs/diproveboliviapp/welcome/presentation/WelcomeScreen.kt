package com.varqulabs.diproveboliviapp.welcome.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.varqulabs.diproveboliviapp.core.domain.imagesVerticalCarruselDiprove
import com.varqulabs.diproveboliviapp.core.presentation.composables.DiproveCarousel
import com.varqulabs.diproveboliviapp.core.presentation.composables.PulsatingContent
import com.varqulabs.diproveboliviapp.ui.theme.BricolageGrotesqueSemiCondensed
import com.varqulabs.diproveboliviapp.welcome.presentation.components.EmergencyButton
import com.varqulabs.diproveboliviapp.welcome.presentation.components.StartButton

@Composable
fun WelcomeScreen(
    onClickStart: () -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(
            top = 16.dp,
            bottom = 24.dp
        ),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        item {
            DiproveCarousel(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .border(
                        width = 2.dp,
                        color = Color(0xFFAB8E32),
                        shape = RoundedCornerShape(12.dp)
                    ),
                list = imagesVerticalCarruselDiprove,
                aspectRatio = 1f,
                infiniteLoop = true
            ) { contentModifier, page ->
                Image(
                    modifier = contentModifier
                        .clip(RoundedCornerShape(12.dp)),
                    contentScale = ContentScale.Crop,
                    painter = painterResource(id = imagesVerticalCarruselDiprove[page]),
                    contentDescription = "Imagen carrusel $page"
                )
            }
        }

        item {
            PulsatingContent {
                Text(
                    modifier = it,
                    text = "¡Bienvenido!",
                    style = TextStyle(
                        fontFamily = BricolageGrotesqueSemiCondensed,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFF388E3C)
                    )
                )
            }
        }

        item {
            StartButton(onClickStart = onClickStart)
        }

        item {
            EmergencyButton(modifier = Modifier.height(70.dp).padding(top = 12.dp))
        }
    }
}