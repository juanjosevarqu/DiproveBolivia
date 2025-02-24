package com.varqulabs.diproveboliviapp.welcome.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.varqulabs.diproveboliviapp.core.domain.imagesHorizontalCarruselDiprove
import com.varqulabs.diproveboliviapp.core.domain.imagesVerticalCarruselDiprove
import com.varqulabs.diproveboliviapp.core.presentation.composables.PulsatingContent
import com.varqulabs.diproveboliviapp.ui.theme.BricolageGrotesqueSemiCondensed
import com.varqulabs.diproveboliviapp.welcome.presentation.components.DiproveCarouselPager
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
            DiproveCarouselPager(
                modifier = Modifier.fillMaxWidth(),
                images = imagesVerticalCarruselDiprove,
                aspectRatio = 1f,
            )
        }

        item {
            StartButton(onClickStart = onClickStart)
        }

        item {
            DiproveCarouselPager(
                modifier = Modifier.fillMaxWidth(),
                images = imagesHorizontalCarruselDiprove,
            )
        }
    }
}