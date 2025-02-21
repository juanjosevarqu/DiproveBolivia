package com.varqulabs.diproveboliviapp.home.home.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.Hyphens
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.varqulabs.diproveboliviapp.core.presentation.utils.modifier.clickableSingle

@Composable
fun IconCardItem(
    @DrawableRes icon: Int,
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(24.dp))
            .background(Color(0xB7E8F5E9))
            .border(
                width = 1.5.dp,
                color = Color(0xFF827717),
                shape = RoundedCornerShape(24.dp),
            )
            .clickableSingle(onClick = onClick)
            .padding(horizontal = 12.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Icon(
            imageVector = ImageVector.vectorResource(icon),
            contentDescription = "Navegar a pantalla",
            tint = Color(0xFFD9AB24),
            modifier = Modifier
                .size(48.dp)
        )

        Text(
            text = text,
            maxLines = 3,
            overflow = TextOverflow.Ellipsis,
            style = TextStyle(
                hyphens = Hyphens.Auto,
                fontSize = 16.sp,
                fontFamily = FontFamily.SansSerif,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Medium,
                color = Color(0xFF827717),
            ),
        )
    }
}