package com.varqulabs.diproveboliviapp.procedures.presentation

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SelectableChipColors
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
import com.varqulabs.diproveboliviapp.core.presentation.DefaultAppBar
import com.varqulabs.diproveboliviapp.core.presentation.composables.ChipItem
import com.varqulabs.diproveboliviapp.core.presentation.composables.CopyIconButton
import com.varqulabs.diproveboliviapp.core.presentation.utils.context.copyToClipboard
import com.varqulabs.diproveboliviapp.core.presentation.utils.modifier.clickableSingle

private val procedures = listOf(
    Pair(R.string.copy_services, R.drawable.tramites_y_servicios_diprove_cbba),
    Pair(R.string.copy_tranference, R.drawable.tranferencia_vehiculo),
    Pair(R.string.copy_missing_plate, R.drawable.extravio_de_placa),
    Pair(R.string.copy_color_change, R.drawable.cambio_color_vehiculo),
    Pair(R.string.copy_structure_change, R.drawable.cambio_de_estructura),
    Pair(R.string.copy_motor_replacement, R.drawable.cambio_de_motor),
    Pair(R.string.copy_authenticity_certificate, R.drawable.certif_autenticidad_vehiculo),
    Pair(R.string.copy_new_registration, R.drawable.inscripcion_nuevo_vehiculo),
    Pair(R.string.copy_chemical_recovery, R.drawable.revenido_quimico),
)

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ProceduresScreen(

) {

    var currentSelected by remember {
        mutableStateOf(procedures.first())
    }

    Scaffold(
        topBar = {
            DefaultAppBar(title = stringResource(R.string.copy_procedures_and_services))
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            contentPadding = PaddingValues(
                top = paddingValues.calculateTopPadding(),
                bottom = paddingValues.calculateBottomPadding(),
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
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                ) {
                    procedures.forEach { item ->
                        ChipItem(
                            text = stringResource(item.first),
                            onClick = {
                                currentSelected = item
                            },
                            selected = item.first == currentSelected.first
                        )
                    }
                }
            }

            item {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp)
                        .clip(RoundedCornerShape(12.dp)),
                    contentScale = ContentScale.FillWidth,
                    painter = painterResource(id = currentSelected.second),
                    contentDescription = "Imagen del procedimiento"
                )
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