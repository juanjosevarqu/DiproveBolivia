package com.varqulabs.diproveboliviapp.home.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.varqulabs.diproveboliviapp.home.home.components.IconCardItem
import com.varqulabs.diproveboliviapp.navigation.HomeScreens
import com.varqulabs.diproveboliviapp.navigation.Routes

private val homeScreens = listOf(
    HomeScreens.DiproveDivisions,
    HomeScreens.Locations,
    HomeScreens.Suggestions,
    HomeScreens.Procedures,
)

@Composable
fun HomeScreen(
    onClickRouteItem: (route: Routes) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(
            top = 24.dp,
            bottom = 12.dp,
            start = 18.dp,
            end = 18.dp
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