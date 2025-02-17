package com.varqulabs.diproveboliviapp.core.presentation.composables

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DiproveFunctionItem(
    modifier: Modifier = Modifier,
    headingText: String,
    @StringRes bodyText: Int,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        Text(
            text = headingText,
            fontSize = 18.sp,
            fontFamily = FontFamily.Serif,
            maxLines = 2,
            fontStyle = FontStyle.Italic,
            overflow = TextOverflow.Ellipsis
        )

        Text(
            text = stringResource(bodyText),
            fontSize = 15.sp,
        )
    }
}