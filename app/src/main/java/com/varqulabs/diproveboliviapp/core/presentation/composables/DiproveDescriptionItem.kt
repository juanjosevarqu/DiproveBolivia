package com.varqulabs.diproveboliviapp.core.presentation.composables

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.Hyphens
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.varqulabs.diproveboliviapp.ui.theme.BricolageGrotesque

@Composable
fun DiproveDescriptionItem(
    modifier: Modifier = Modifier,
    headingText: String,
    @StringRes bodyText: Int,
    headingStyle: TextStyle = TextStyle(
        fontSize = 20.sp,
        fontFamily = BricolageGrotesque,
        fontWeight = FontWeight.SemiBold,
    ),
    bodyStyle: TextStyle = TextStyle(
        textAlign = TextAlign.Justify,
        hyphens = Hyphens.Auto,
        fontSize = 15.sp,
        lineHeight = 26.sp,
        fontFamily = BricolageGrotesque
    ),
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = headingText,
            style = headingStyle,
            maxLines = 4,
            overflow = TextOverflow.Ellipsis
        )

        Text(
            text = stringResource(bodyText),
            style = bodyStyle,
        )
    }
}