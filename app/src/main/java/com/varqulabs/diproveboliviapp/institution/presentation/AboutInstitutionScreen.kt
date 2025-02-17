package com.varqulabs.diproveboliviapp.institution.presentation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.FlowRowOverflow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.varqulabs.diproveboliviapp.R
import com.varqulabs.diproveboliviapp.core.presentation.DefaultAppBar
import com.varqulabs.diproveboliviapp.core.presentation.composables.ChipItem
import com.varqulabs.diproveboliviapp.core.presentation.composables.DiproveFunctionItem

data class DiproveDivision(
    @StringRes val name: Int,
    @StringRes val description: Int,
    @DrawableRes val image: Int? = null,
)

private val diproveDivisions = listOf(
    DiproveDivision(
        name = R.string.copy_platform_division,
        description = R.string.copy_platform_division_functions,
    ),
    DiproveDivision(
        name = R.string.copy_investigators_division,
        description = R.string.copy_investigator_division_functions,
    ),
    DiproveDivision(
        name = R.string.copy_vehicle_identification_division,
        description = R.string.copy_vehicle_identification_division_functions,
    ),
    DiproveDivision(
        name = R.string.copy_criminal_analysis_and_intelligence_division,
        description = R.string.copy_analysis_and_intelligence_division_functions,
    ),
    DiproveDivision(
        name = R.string.copy_records_division,
        description = R.string.copy_records_division_functions,
    ),
)

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun AboutInstitutionScreen(
    modifier: Modifier = Modifier
) {

    var currentSelected by remember {
        mutableStateOf(diproveDivisions.first())
    }

    Scaffold(
        topBar = {
            DefaultAppBar(title = stringResource(R.string.copy_about_institution))
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            contentPadding = PaddingValues(
                top = paddingValues.calculateTopPadding(),
                bottom = paddingValues.calculateBottomPadding() + 24.dp,
                start = 16.dp,
                end = 16.dp
            )
        ) {
            item {
                FlowRow(
                    overflow = FlowRowOverflow.Clip,
                    modifier = Modifier.fillMaxWidth(1f),
                    verticalArrangement = Arrangement.spacedBy(0.dp),
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                ) {
                    diproveDivisions.forEach { division ->
                        ChipItem(
                            text = stringResource(division.name),
                            onClick = {
                                currentSelected = division
                            },
                            selected = division == currentSelected
                        )
                    }
                }
            }

            item {
                DiproveFunctionItem(
                    modifier = Modifier.fillMaxWidth(),
                    headingText = "${stringResource(currentSelected.name)}:",
                    bodyText = currentSelected.description,
                )
            }
        }
    }
}