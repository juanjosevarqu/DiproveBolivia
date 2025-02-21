package com.varqulabs.diproveboliviapp.home.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.varqulabs.diproveboliviapp.core.presentation.composables.DiproveCenterAppBar
import com.varqulabs.diproveboliviapp.core.presentation.composables.DiprovePoliceBackgroundContainer
import com.varqulabs.diproveboliviapp.home.home.components.IconCardItem
import com.varqulabs.diproveboliviapp.navigation.HomeScreens

val homeScreens = listOf(
    HomeScreens.DiproveDivisions,
    HomeScreens.Locations,
    HomeScreens.Suggestions,
    HomeScreens.Procedures,
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onClickRouteItem: (route: Any) -> Unit
) {

    Scaffold(
        topBar = {
            DiproveCenterAppBar(
                title = "DIPROVE COCHABAMBA",
            )
        },
        containerColor = Color(0xFFFEFEFE)
    ) { paddingValues ->
        DiprovePoliceBackgroundContainer(
            modifierImage = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            color = Color(0xFFC3C3C3)
        ) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = it,
                contentPadding = PaddingValues(
                    top = paddingValues.calculateTopPadding() + 24.dp,
                    bottom = paddingValues.calculateBottomPadding() + 12.dp,
                    start = 12.dp,
                    end = 12.dp
                ),
                horizontalArrangement = Arrangement.spacedBy(24.dp),
                verticalArrangement = Arrangement.spacedBy(24.dp, Alignment.CenterVertically)
            ) {
                items(homeScreens) { screen ->
                    IconCardItem(
                        modifier = Modifier.size(148.dp),
                        icon = screen.icon,
                        text = screen.name,
                        onClick = { onClickRouteItem(screen.route) }
                    )
                }
            }
        }
    }
}