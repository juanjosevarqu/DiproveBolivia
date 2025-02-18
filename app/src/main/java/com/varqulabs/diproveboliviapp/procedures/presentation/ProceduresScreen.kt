package com.varqulabs.diproveboliviapp.procedures.presentation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.FlowRowOverflow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.mapSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.varqulabs.diproveboliviapp.R
import com.varqulabs.diproveboliviapp.core.domain.BANK_NUMBER
import com.varqulabs.diproveboliviapp.core.domain.BANK_NUMBER_COPY
import com.varqulabs.diproveboliviapp.core.presentation.composables.DefaultAppBar
import com.varqulabs.diproveboliviapp.core.presentation.composables.ChipItem
import com.varqulabs.diproveboliviapp.core.presentation.composables.CopyIconButton
import com.varqulabs.diproveboliviapp.core.presentation.composables.DiprovePoliceBackgroundContainer
import com.varqulabs.diproveboliviapp.core.presentation.utils.context.copyToClipboard
import com.varqulabs.diproveboliviapp.core.presentation.utils.modifier.clickableSingle

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

@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
@Composable
fun ProceduresScreen(

) {

    var currentSelected by rememberSaveable(stateSaver = ProcedureDiproveSaver) {
        mutableStateOf<ProcedureDiprove?>(null)
    }

    Scaffold(
        topBar = {
            DefaultAppBar(title = stringResource(R.string.copy_services_offered))
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
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                contentPadding = PaddingValues(
                    top = paddingValues.calculateTopPadding(),
                    bottom = paddingValues.calculateBottomPadding() + 18.dp,
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
                    FlowRow(
                        overflow = FlowRowOverflow.Clip,
                        modifier = Modifier.fillMaxWidth(1f),
                        verticalArrangement = Arrangement.spacedBy(0.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
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
                                    .padding(bottom = 12.dp)
                                    .clip(RoundedCornerShape(12.dp)),
                                contentScale = ContentScale.FillWidth,
                                painter = painterResource(id = procedure.image),
                                contentDescription = "Imagen del procedimiento"
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun BankNumberAndCopy(
    modifier: Modifier = Modifier
) {

    val context = LocalContext.current

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {

        Text(
            text = stringResource(R.string.copy_banco_union_number_account),
            fontWeight = FontWeight.Medium
        )

        Row(
            modifier = Modifier.padding(start = 8.dp, end = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically,
        ) {

            Text(
                text = "N° $BANK_NUMBER",
                fontWeight = FontWeight.SemiBold,
                fontSize = 28.sp,
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

private val ProcedureDiproveSaver = run {
    mapSaver<ProcedureDiprove?>(
        save = {
            mapOf(
                id_name to (it?.name ?: 0),
                id_procedure_img to (it?.image ?: R.drawable.tramites_y_servicios_diprove_cbba)
            )
        },
        restore = {
            ProcedureDiprove(
                name = it[id_name] as Int,
                image = it[id_procedure_img] as Int
            )
        }
    )
}