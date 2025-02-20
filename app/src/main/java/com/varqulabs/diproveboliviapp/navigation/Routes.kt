package com.varqulabs.diproveboliviapp.navigation

import androidx.annotation.DrawableRes
import com.varqulabs.diproveboliviapp.R
import kotlinx.serialization.Serializable

@Serializable
data object HomeRoute

@Serializable
data object WelcomeScreen

@Serializable
data object HomeScreen

@Serializable
data object LocationsRoute

@Serializable
data object ProceduresRoute

@Serializable
data object DivisionsRoute

@Serializable
data object DivisionsHomeScreen

@Serializable
data class DiproveDivisionScreen(val divisionId: Int)

@Serializable
data object AboutAppRoute

@Serializable
data object SuggestionsRoute

@Serializable
sealed class HomeScreens<T>(val name: String, @DrawableRes val icon: Int, val route: T) {

    @Serializable
    data object Locations : HomeScreens<LocationsRoute>(name = "Direcciones", icon = R.drawable.baseline_share_location_24, route = LocationsRoute)

    @Serializable
    data object Procedures : HomeScreens<ProceduresRoute>(name = "Tramites y Servicios", icon = R.drawable.baseline_notes_24, route = ProceduresRoute)

    @Serializable
    data object DiproveDivisions : HomeScreens<DivisionsRoute>(name = "Divisiones", icon = R.drawable.baseline_other_houses_24, route = DivisionsRoute)

    @Serializable
    data object Suggestions : HomeScreens<SuggestionsRoute>(name = "Recomendaciones", icon = R.drawable.baseline_recommend_24, route = SuggestionsRoute)

}
