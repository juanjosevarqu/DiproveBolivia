package com.varqulabs.diproveboliviapp.suggestions.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.varqulabs.diproveboliviapp.R
import com.varqulabs.diproveboliviapp.core.presentation.composables.DiproveDescriptionItem

@Composable
fun SuggestionsScreen(
) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(
            start = 24.dp,
            end = 24.dp,
            top = 12.dp,
            bottom = 80.dp
        ),
        verticalArrangement = Arrangement.spacedBy(28.dp)
    ) {
        items(4) { number ->
            DiproveDescriptionItem(
                modifier = Modifier.fillMaxWidth(),
                headingText = "Recomedacion ${number + 1}",
                bodyText = R.string.copy_diprove_regional_suggestion_demo
            )
        }
    }
}