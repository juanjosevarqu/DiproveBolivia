package com.varqulabs.diproveboliviapp.locations.presentation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.FlowRowOverflow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.varqulabs.diproveboliviapp.R
import com.varqulabs.diproveboliviapp.core.presentation.DefaultAppBar
import com.varqulabs.diproveboliviapp.core.presentation.composables.ChipItem
import com.varqulabs.diproveboliviapp.core.presentation.utils.context.launchExternalIntent
import com.varqulabs.diproveboliviapp.core.presentation.utils.modifier.clickableSingle

private data class RegionalDiproveLocation(
    @StringRes val title: Int,
    @DrawableRes val previewLocationImg: Int,
    val googleMapsURL: String,
)

private val regionalDiproveLocations = listOf(
    RegionalDiproveLocation(
        title = R.string.copy_diprove_central,
        previewLocationImg = R.drawable.diprove_central_ubicacion,
        googleMapsURL = "https://maps.app.goo.gl/XTVdRRLkorkYJWbx7"
    ),
    RegionalDiproveLocation(
        title = R.string.copy_diprove_valle_bajo,
        previewLocationImg = R.drawable.diprove_quillacollo_v_bajo_ubicacion,
        googleMapsURL = "https://maps.app.goo.gl/Wwb3nHtuMkou7REG8"
    ),
    RegionalDiproveLocation(
        title = R.string.copy_diprove_sacaba,
        previewLocationImg = R.drawable.diprove_sacaba_ubicacion,
        googleMapsURL = "https://maps.app.goo.gl/2ja4EeG16oc7EkuDA"
    ),
    RegionalDiproveLocation(
        title = R.string.copy_diprove_epi_sur,
        previewLocationImg = R.drawable.diprove_epi_sur_ubicacion,
        googleMapsURL = "https://maps.app.goo.gl/xiYziSty8tRJDSMB7"
    ),
    RegionalDiproveLocation(
        title = R.string.copy_diprove_valle_alto,
        previewLocationImg = R.drawable.diprove_punata_v_alto_ubicacion,
        googleMapsURL = "https://maps.app.goo.gl/zzxScdFNJGtNk8o8A"
    ),
)

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun RegionalLocationsScreen(

) {

    val context = LocalContext.current

    var currentRegionalSelected by remember {
        mutableStateOf(regionalDiproveLocations.first())
    }

    Scaffold(
        topBar = {
            DefaultAppBar(title = stringResource(R.string.copy_diprove_regionals)) { }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(
                top = paddingValues.calculateTopPadding(),
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
                    regionalDiproveLocations.forEach { regional ->
                        ChipItem(
                            text = stringResource(regional.title),
                            onClick = { currentRegionalSelected = regional },
                            selected = regional == currentRegionalSelected
                        )
                    }
                }
            }

            item {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f)
                        .clip(RoundedCornerShape(12.dp))
                        .clickableSingle { context.launchExternalIntent(currentRegionalSelected.googleMapsURL) },
                    contentScale = ContentScale.FillWidth,
                    painter = painterResource(id = currentRegionalSelected.previewLocationImg),
                    contentDescription = "Ubicacion de la regional"
                )
            }

            item {
                Button(
                    onClick = { context.launchExternalIntent(currentRegionalSelected.googleMapsURL) },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF26334C),
                    )
                ) {
                    Row(
                        modifier = Modifier,
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {

                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.round_directions_24),
                            contentDescription = "Abrir en google maps"
                        )

                        Text(
                            text = "Ver en Google Maps",
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}