package com.varqulabs.diproveboliviapp.core.presentation.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.varqulabs.diproveboliviapp.R
import com.varqulabs.diproveboliviapp.ui.theme.BricolageGrotesque

@Composable
fun CopyIconButton(modifier: Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_copy),
            contentDescription = null,
            tint = Color(0xFF266748),
            modifier = Modifier.size(11.dp),
        )

        Text(
            text = "Copiar",
            style = TextStyle(
                fontSize = 12.sp,
                fontFamily = BricolageGrotesque,
                color = Color(0xFF266748),
            ),
        )
    }
}