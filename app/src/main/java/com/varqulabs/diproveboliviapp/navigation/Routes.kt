package com.varqulabs.diproveboliviapp.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.varqulabs.diproveboliviapp.R
import kotlinx.serialization.Serializable

@Serializable
sealed class Routes(@StringRes val title : Int) {

    @Serializable
    data object Welcome : Routes(title = R.string.copy_diprove_cbba)

    @Serializable
    data object Home : Routes(title = R.string.copy_diprove_cbba)

    @Serializable
    data object Locations : Routes(title = R.string.copy_diprove_regional_directorates)

    @Serializable
    data object Procedures : Routes(title = R.string.copy_services_offered)

    @Serializable
    data object Suggestions : Routes(title = R.string.copy_diprove_suggestions)

    @Serializable
    data object Divisions_Home : Routes(title = R.string.copy_diprove_cbba_divisions)

    @Serializable
    data class Divisions_Detail(val divisionId: Int) : Routes(title = R.string.copy_diprove_cbba_divisions)

}

@Serializable
sealed class HomeScreens<T>(@DrawableRes val icon: Int, val name: String, val route: T) {

    @Serializable
    data object DiproveDivisions : HomeScreens<Routes>(name = "Divisiones", icon = R.drawable.division_structure_bold, route = Routes.Divisions_Home)

    @Serializable
    data object Locations : HomeScreens<Routes>(name = "Direcciones", icon = R.drawable.region_map_rect, route = Routes.Locations)

    @Serializable
    data object Suggestions : HomeScreens<Routes>(name = "Recomendaciones", icon = R.drawable.summary_check_rect, route = Routes.Suggestions)

    @Serializable
    data object Procedures : HomeScreens<Routes>(name = "Tramites y Servicios", icon = R.drawable.documents_papers, route = Routes.Procedures)

}