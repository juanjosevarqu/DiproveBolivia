package com.varqulabs.diproveboliviapp.navigation

import com.varqulabs.diproveboliviapp.R
import kotlinx.serialization.Serializable

@Serializable
data object HomeRoute

@Serializable
data object LocationsRoute

@Serializable
data object ProceduresRoute

@Serializable
data object AboutInstitutionRoute

@Serializable
data object AboutAppRoute

@Serializable
sealed class BottomScreens<T>(val name: String, val icon: Int, val route: T) {

    @Serializable
    data object Home : BottomScreens<HomeRoute>(name = "Inicio", icon = R.drawable.baseline_home_24, route = HomeRoute)

    @Serializable
    data object Locations : BottomScreens<LocationsRoute>(name = "Direcciones", icon = R.drawable.baseline_share_location_24, route = LocationsRoute)

    @Serializable
    data object Procedures : BottomScreens<ProceduresRoute>(name = "Tramites", icon = R.drawable.baseline_notes_24, route = ProceduresRoute)

    @Serializable
    data object AboutInstitution : BottomScreens<AboutInstitutionRoute>(name = "Institución", icon = R.drawable.baseline_business_24, route = AboutInstitutionRoute)

}

