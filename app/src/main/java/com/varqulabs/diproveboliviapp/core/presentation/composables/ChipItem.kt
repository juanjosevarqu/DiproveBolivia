package com.varqulabs.diproveboliviapp.core.presentation.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SelectableChipColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ChipItem(
    text: String,
    onClick: () -> Unit = {},
    selected: Boolean = false,
) {
    FilterChip(
        modifier = Modifier.padding(end = 4.dp),
        onClick = onClick,
        leadingIcon = {},
        border = BorderStroke(1.dp, Color(0xFF004D40)),
        shape = MaterialTheme.shapes.large,
        label = {
            Text(text = text)
        },
        selected = selected,
        colors = SelectableChipColors(
            containerColor = Color.Transparent,
            labelColor = Color(0xFF133121),
            leadingIconColor = Color(0xFF266748),
            trailingIconColor = Color(0xFF266748),
            disabledContainerColor = Color(0xFFE6F4E0),
            disabledLabelColor = Color(0xFF266748),
            disabledLeadingIconColor = Color(0xFF266748),
            disabledTrailingIconColor = Color(0xFF266748),
            selectedContainerColor = Color(0xFF257240),
            disabledSelectedContainerColor = Color(0xFFE6F4E0),
            selectedLabelColor = Color(0xFFFFFFFF),
            selectedLeadingIconColor = Color(0xFF266748),
            selectedTrailingIconColor = Color(0xFF266748)
        )
    )
}