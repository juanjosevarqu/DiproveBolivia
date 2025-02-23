package com.varqulabs.diproveboliviapp.procedures.presentation

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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.varqulabs.diproveboliviapp.R
import com.varqulabs.diproveboliviapp.core.domain.BANK_NUMBER
import com.varqulabs.diproveboliviapp.core.domain.BANK_NUMBER_COPY
import com.varqulabs.diproveboliviapp.core.presentation.composables.ChipItem
import com.varqulabs.diproveboliviapp.core.presentation.composables.CopyIconButton
import com.varqulabs.diproveboliviapp.core.presentation.composables.DiproveCenterAppBar
import com.varqulabs.diproveboliviapp.core.presentation.composables.DiprovePoliceBackgroundContainer
import com.varqulabs.diproveboliviapp.core.presentation.utils.context.copyToClipboard
import com.varqulabs.diproveboliviapp.core.presentation.utils.modifier.clickableSingle
import com.varqulabs.diproveboliviapp.ui.theme.BricolageGrotesque

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProceduresScreen(

) {

    val lazyListState = rememberLazyListState()
    var currentSelected by rememberSaveable(stateSaver = ProcedureDiproveSaver) {
        mutableStateOf<ProcedureDiprove?>(null)
    }
    val density = LocalDensity.current
    val itemSizePx = remember { with(density) { 360.dp.toPx() } }

    LaunchedEffect(currentSelected) {
        if (currentSelected != null) {
            lazyListState.animateScrollBy(
                value = itemSizePx * 1,
                animationSpec = tween(1200)
            )
        }
    }

    /*Scaffold(
        topBar = {
            DiproveCenterAppBar(
                title = stringResource(R.string.copy_services_offered),
            )
        },
        containerColor = Color(0xFFFEFEFE)
    ) { paddingValues ->
        DiprovePoliceBackgroundContainer(
            modifierImage = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {*/
            LazyColumn(
                state = lazyListState,
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                contentPadding = PaddingValues(
                    top = 16.dp,
                    bottom = 80.dp,
                    start = 16.dp,
                    end = 16.dp
                )
            ) {

                item {
                    BankNumberAndCopy(
                        modifier = Modifier.fillMaxWidth()
                    )
                }

                item {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(0.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        procedures.forEach { procedure ->
                            ChipItem(
                                text = stringResource(procedure.name),
                                onClick = { currentSelected = procedure },
                                selected = procedure == currentSelected
                            )
                        }
                    }
                }

                if (currentSelected != null) {
                    currentSelected?.let { procedure ->
                        item {
                            Image(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(12.dp))
                                    .border(
                                        width = 1.dp,
                                        color = Color(0xFFD0A82D),
                                        shape = RoundedCornerShape(12.dp)
                                    ),
                                contentScale = ContentScale.FillWidth,
                                painter = painterResource(id = procedure.image),
                                contentDescription = "Imagen del procedimiento"
                            )
                        }
                    }
                }
            }
        /*}
    }*/
}

@Composable
private fun BankNumberAndCopy(
    modifier: Modifier = Modifier
) {

    val context = LocalContext.current

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Text(
            text = stringResource(R.string.copy_banco_union_number_account),
            style = TextStyle(
                fontSize = 18.sp,
                fontFamily = BricolageGrotesque,
                fontWeight = FontWeight.Medium,
            ),
        )

        Row(
            modifier = Modifier.padding(start = 8.dp, end = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically,
        ) {

            Text(
                text = "N° $BANK_NUMBER",
                style = TextStyle(
                    fontSize = 28.sp,
                    fontWeight = FontWeight.SemiBold,
                ),
                modifier = Modifier.align(Alignment.Top)
            )

            CopyIconButton(
                modifier = Modifier
                    .clip(RoundedCornerShape(4.dp))
                    .clickableSingle {
                        context.copyToClipboard(
                            text = BANK_NUMBER_COPY,
                        )
                    }
                    .align(Alignment.Bottom)
            )
        }
    }
}

private data class ProcedureDiprove(
    @StringRes val name: Int,
    @DrawableRes val image: Int,
)

private const val id_name = "ID_NAME"
private const val id_procedure_img = "ID_PROCEDURE_IMG"

private val ProcedureDiproveSaver = mapSaver<ProcedureDiprove?>(
    save = { procedure ->
        if (procedure == null) {
            emptyMap()
        } else {
            mapOf(
                id_name to procedure.name,
                id_procedure_img to procedure.image
            )
        }
    },
    restore = { map ->
        if (map.isEmpty()) {
            null
        } else {
            ProcedureDiprove(
                name = map[id_name] as Int,
                image = map[id_procedure_img] as Int
            )
        }
    }
)

private val procedures = listOf(
    ProcedureDiprove(
        name = R.string.copy_tranference,
        image = R.drawable.tranferencia_vehiculo
    ),
    ProcedureDiprove(
        name = R.string.copy_missing_plate,
        image = R.drawable.extravio_de_placa
    ),
    ProcedureDiprove(
        name = R.string.copy_color_change,
        image = R.drawable.cambio_color_vehiculo
    ),
    ProcedureDiprove(
        name = R.string.copy_structure_change,
        image = R.drawable.cambio_de_estructura
    ),
    ProcedureDiprove(
        name = R.string.copy_motor_replacement,
        image = R.drawable.cambio_de_motor
    ),
    ProcedureDiprove(
        name = R.string.copy_authenticity_certificate,
        image = R.drawable.certif_autenticidad_vehiculo
    ),
    ProcedureDiprove(
        name = R.string.copy_new_registration,
        image = R.drawable.inscripcion_nuevo_vehiculo
    ),
    ProcedureDiprove(
        name = R.string.copy_chemical_recovery,
        image = R.drawable.revenido_quimico
    ),
)