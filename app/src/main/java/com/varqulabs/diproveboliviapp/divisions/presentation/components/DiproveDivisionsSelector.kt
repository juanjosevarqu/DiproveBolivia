package com.varqulabs.diproveboliviapp.divisions.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.varqulabs.diproveboliviapp.core.presentation.composables.ChipItem
import com.varqulabs.diproveboliviapp.domain.diproveDivisions

@Composable
fun DiproveDivisionsSelector(
    modifier: Modifier = Modifier,
    onClickDivision: (divisionId: Int) -> Unit
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        diproveDivisions.forEach { division ->
            ChipItem(
                text = stringResource(division.name),
                onClick = { onClickDivision(division.id) },
                selected = true
            )
        }
    }
}