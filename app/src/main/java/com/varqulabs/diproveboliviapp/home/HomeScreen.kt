package com.varqulabs.diproveboliviapp.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.varqulabs.diproveboliviapp.core.ui.DefaultAppBar

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    provisionalName: String,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            DefaultAppBar(title = "Pantalla de $provisionalName") {  }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {  },
                modifier = Modifier.navigationBarsPadding().padding(bottom = 40.dp),
                shape = FloatingActionButtonDefaults.largeShape,
                containerColor = Color(0xFF3ECA63),
                contentColor = Color.White,
            ) {
                Icon(
                    imageVector = Icons.Filled.Phone,
                    contentDescription = "Whatsapp Diprove",
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(24.dp, Alignment.CenterVertically)
        ) {

            Text(
                text = "Contenido",
            )

            Button(
                onClick = {  }
            ) {
                Text("Accion específica")
            }
        }
    }
}