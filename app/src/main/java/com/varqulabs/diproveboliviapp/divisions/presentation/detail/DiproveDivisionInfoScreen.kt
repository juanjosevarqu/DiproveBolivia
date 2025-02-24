package com.varqulabs.diproveboliviapp.divisions.presentation.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.varqulabs.diproveboliviapp.core.presentation.composables.DiproveDescriptionItem
import com.varqulabs.diproveboliviapp.domain.DiproveDivision
import com.varqulabs.diproveboliviapp.ui.theme.BricolageGrotesque
import com.varqulabs.diproveboliviapp.ui.theme.BricolageGrotesqueSemiCondensed

@Composable
fun DiproveDivisionInfoScreen(
    modifier: Modifier = Modifier,
    diproveDivision: DiproveDivision,
    onBack: () -> Unit
) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .padding(top = 48.dp, bottom = 72.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {

        Image(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(16 / 9F),
            contentScale = ContentScale.FillWidth,
            painter = painterResource(id = diproveDivision.image),
            contentDescription = "Imagen de la division"
        )

        DiproveDescriptionItem(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
                .padding(horizontal = 16.dp),
            headingText = stringResource(diproveDivision.name),
            bodyText = diproveDivision.description,
            headingStyle = TextStyle(
                fontSize = 22.sp,
                fontFamily = BricolageGrotesque,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                textDecoration = TextDecoration.Underline,
            ),
            bodyStyle = TextStyle(
                textAlign = TextAlign.Justify,
                hyphens = Hyphens.Auto,
                fontSize = 16.sp,
                lineHeight = 28.sp,
                fontFamily = BricolageGrotesqueSemiCondensed
            ),
        )
    }
}