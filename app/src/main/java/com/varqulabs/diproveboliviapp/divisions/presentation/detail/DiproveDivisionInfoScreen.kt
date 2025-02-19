package com.varqulabs.diproveboliviapp.divisions.presentation.detail

import android.graphics.Paint.Align
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.varqulabs.diproveboliviapp.core.presentation.composables.DiproveDescriptionItem
import com.varqulabs.diproveboliviapp.domain.DiproveDivision

@Composable
fun DiproveDivisionInfoScreen(
    modifier: Modifier = Modifier,
    diproveDivision: DiproveDivision,
    onBack: () -> Unit
) {
    Column(
        modifier = modifier.verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(24.dp, Alignment.CenterVertically)
    ) {

        IconButton(
            onClick = onBack,
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                contentDescription = "Volver atrás"
            )
        }

        DiproveDescriptionItem(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
                .padding(horizontal = 24.dp),
            headingText = "${stringResource(diproveDivision.name)}:",
            bodyText = diproveDivision.description,
        )
    }
}