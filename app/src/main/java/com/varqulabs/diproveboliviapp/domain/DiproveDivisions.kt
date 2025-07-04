package com.varqulabs.diproveboliviapp.domain

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.varqulabs.diproveboliviapp.R

data class DiproveDivision(
    val id: Int = 1,
    @StringRes val name: Int = R.string.copy_platform_division,
    @StringRes val description: Int = R.string.copy_platform_division_functions,
    @DrawableRes val image: Int = R.drawable.diprove_records_division,
)

val diproveDivisions = listOf(
    DiproveDivision(
        id = 1,
        name = R.string.copy_platform_division,
        description = R.string.copy_platform_division_functions,
        image = R.drawable.diprove_platform_division,
    ),
    DiproveDivision(
        id = 2,
        name = R.string.copy_investigators_division,
        description = R.string.copy_investigator_division_functions,
        image = R.drawable.diprove_investigators_division
    ),
    DiproveDivision(
        id = 3,
        name = R.string.copy_vehicle_identification_division,
        description = R.string.copy_vehicle_identification_division_functions,
        image = R.drawable.diprove_vehicle_division
    ),
    DiproveDivision(
        id = 4,
        name = R.string.copy_criminal_analysis_and_intelligence_division,
        description = R.string.copy_analysis_and_intelligence_division_functions,
        image = R.drawable.diprove_analysis_intelligence_division,
    ),
    DiproveDivision(
        id = 5,
        name = R.string.copy_records_division,
        description = R.string.copy_records_division_functions,
        image = R.drawable.diprove_records_division
    ),
)

val diproveDivisionsMap = diproveDivisions.associateBy { it.id }