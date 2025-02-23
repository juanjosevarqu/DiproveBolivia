package com.varqulabs.diproveboliviapp.locations.presentation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.animateScrollBy
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.mapSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.Hyphens
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.varqulabs.diproveboliviapp.R
import com.varqulabs.diproveboliviapp.core.presentation.composables.ChipItem
import com.varqulabs.diproveboliviapp.core.presentation.utils.context.launchExternalIntent
import com.varqulabs.diproveboliviapp.core.presentation.utils.modifier.clickableSingle
import com.varqulabs.diproveboliviapp.ui.theme.BricolageGrotesque

@Composable
fun RegionalLocationsScreen(

) {

    val lazyListState = rememberLazyListState()
    var currentRegionalSelected by rememberSaveable(stateSaver = RegionalDiproveLocationSaver) {
        mutableStateOf<RegionalDiproveLocation?>(null)
    }

    val density = LocalDensity.current
    val itemSizePx = remember { with(density) { 360.dp.toPx() } }

    LaunchedEffect(currentRegionalSelected) {
        if (currentRegionalSelected != null) {
            lazyListState.animateScrollBy(
                value = itemSizePx * 1,
                animationSpec = tween(1200)
            )
        }
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        state = lazyListState,
        verticalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(
            top = 24.dp,
            start = 16.dp,
            end = 16.dp,
            bottom = 24.dp
        )
    ) {

        item {
            Text(
                text = "Recomendación",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontFamily = BricolageGrotesque,
                    fontWeight = FontWeight.SemiBold,
                ),
            )
        }

        item {
            Text(
                text = stringResource(R.string.copy_diprove_regional_suggestion),
                style = TextStyle(
                    textAlign = TextAlign.Justify,
                    hyphens = Hyphens.Auto,
                    fontSize = 14.sp,
                    lineHeight = 22.sp,
                    fontFamily = BricolageGrotesque,
                    fontWeight = FontWeight.Medium
                ),
            )
        }

        item {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(4.dp),
                horizontalAlignment = Alignment.CenterHorizontally
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

        if (currentRegionalSelected != null) {
            currentRegionalSelected?.let {
                item {
                    PreviewLocationGoogleMaps(
                        modifier = Modifier.fillMaxWidth(),
                        googleMapsURL = it.googleMapsURL,
                        previewLocationImg = it.previewLocationImg
                    )
                }
            }
        }
    }
}

@Composable
fun PreviewLocationGoogleMaps(
    modifier: Modifier = Modifier,
    googleMapsURL: String,
    @DrawableRes previewLocationImg: Int,
) {

    val context = LocalContext.current

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        Image(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .clip(RoundedCornerShape(12.dp))
                .border(
                    width = 2.dp,
                    color = Color(0xFFD0A82D),
                    shape = RoundedCornerShape(12.dp)
                )
                .clickableSingle { context.launchExternalIntent(googleMapsURL) },
            contentScale = ContentScale.FillWidth,
            painter = painterResource(id = previewLocationImg),
            contentDescription = "Ubicacion de la regional"
        )

        ButtonWithLeadingIcon(
            icon = R.drawable.round_directions_24,
            text = "Ver en Google Maps",
            onClick = { context.launchExternalIntent(googleMapsURL) }
        )
    }
}

@Composable
fun ButtonWithLeadingIcon(
    @DrawableRes icon: Int,
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier,
        onClick = onClick,
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
                imageVector = ImageVector.vectorResource(icon),
                contentDescription = "Execute action"
            )

            Text(
                text = text,
                color = Color.White
            )
        }
    }
}

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

private data class RegionalDiproveLocation(
    @StringRes val title: Int,
    @DrawableRes val previewLocationImg: Int,
    val googleMapsURL: String,
)

private const val id_title = "ID_TITLE"
private const val id_previewLocationImg = "ID_PREVIEW_LOCATION_IMG"
private const val id_googleMapsURL = "ID_GOOGLE_MAPS_URL"

private val RegionalDiproveLocationSaver = mapSaver<RegionalDiproveLocation?>(
    save = { location ->
        if (location == null) {
            emptyMap()
        } else {
            mapOf(
                id_title to location.title,
                id_previewLocationImg to location.previewLocationImg,
                id_googleMapsURL to location.googleMapsURL
            )
        }
    },
    restore = { map ->
        if (map.isEmpty()) {
            null
        } else {
            RegionalDiproveLocation(
                title = map[id_title] as Int,
                previewLocationImg = map[id_previewLocationImg] as Int,
                googleMapsURL = map[id_googleMapsURL] as String
            )
        }
    }
)