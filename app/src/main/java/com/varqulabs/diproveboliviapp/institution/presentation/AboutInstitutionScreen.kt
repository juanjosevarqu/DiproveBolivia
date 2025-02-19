package com.varqulabs.diproveboliviapp.institution.presentation

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.mapSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.varqulabs.diproveboliviapp.R
import com.varqulabs.diproveboliviapp.core.presentation.composables.DefaultAppBar
import com.varqulabs.diproveboliviapp.core.presentation.composables.ChipItem
import com.varqulabs.diproveboliviapp.core.presentation.composables.DiproveFunctionItem
import com.varqulabs.diproveboliviapp.core.presentation.composables.DiprovePoliceBackgroundContainer

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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutInstitutionScreen(
    modifier: Modifier = Modifier
) {

    var currentSelected by rememberSaveable(stateSaver = DiproveDivisionSaver) {
        mutableStateOf<DiproveDivision?>(null)
    }

    Scaffold(
        topBar = {
            DefaultAppBar(
                title = stringResource(R.string.copy_diprove_cbba_divisions),
                actions = {
                    Image(
                        modifier = Modifier.size(92.dp),
                        painter = painterResource(id = R.drawable.logo_policia_boliviana),
                        contentDescription = "Logo Policia boliviana"
                    )
                },
            )
        },
        containerColor = Color(0xFFFEFEFE)
    ) { paddingValues ->
        DiprovePoliceBackgroundContainer(
            modifierImage = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            LazyColumn(
                modifier = it,
                verticalArrangement = Arrangement.spacedBy(24.dp, Alignment.CenterVertically),
                horizontalAlignment = Alignment.CenterHorizontally,
                contentPadding = PaddingValues(
                    top = paddingValues.calculateTopPadding() + 12.dp,
                    bottom = paddingValues.calculateBottomPadding() + 24.dp,
                    start = 16.dp,
                    end = 16.dp
                )
            ) {
                item {
                    Column(
                        modifier = Modifier.fillMaxWidth(1f),
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
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

                currentSelected?.let {
                    item {
                        DiproveFunctionItem(
                            modifier = Modifier.fillMaxWidth(),
                            headingText = "${stringResource(it.name)}:",
                            bodyText = it.description,
                        )
                    }
                }
            }
        }
    }
}

private data class DiproveDivision(
    @StringRes val name: Int,
    @StringRes val description: Int,
)

private const val id_name = "ID_NAME"
private const val id_description = "ID_DESCRIPTION"

private val DiproveDivisionSaver = run {
    mapSaver<DiproveDivision?>(
        save = {
            mapOf(
                id_name to (it?.name ?: R.string.copy_platform_division),
                id_description to (it?.description ?: R.string.copy_platform_division_functions),
            )
        },
        restore = {
            DiproveDivision(
                name = it[id_name] as Int,
                description = it[id_description] as Int,
            )
        }
    )
}