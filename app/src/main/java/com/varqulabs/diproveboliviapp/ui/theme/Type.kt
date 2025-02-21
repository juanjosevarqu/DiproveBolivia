package com.varqulabs.diproveboliviapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.varqulabs.diproveboliviapp.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)

val BricolageGrotesque = FontFamily(
    Font(R.font.bricolage_grotesque_regular, FontWeight.Normal),
    Font(R.font.bricolage_grotesque_medium, FontWeight.Medium),
    Font(R.font.bricolage_grotesque_semi_bold, FontWeight.SemiBold),
    Font(R.font.bricolage_grotesque_bold, FontWeight.Bold),
    Font(R.font.bricolage_grotesque_extra_bold, FontWeight.ExtraBold),
    Font(R.font.bricolage_grotesque_light, FontWeight.Light),
    Font(R.font.bricolage_grotesque_extra_light, FontWeight.ExtraLight),
)

val BricolageGrotesqueSemiCondensed = FontFamily(
    Font(R.font.bricolage_grotesque_semi_condensed_regular, FontWeight.Normal),
    Font(R.font.bricolage_grotesque_semi_condensed_medium, FontWeight.Medium),
    Font(R.font.bricolage_grotesque_semi_condensed_semi_bold, FontWeight.SemiBold),
    Font(R.font.bricolage_grotesque_semi_condensed_bold, FontWeight.Bold),
    Font(R.font.bricolage_grotesque_semi_condensed_extra_bold, FontWeight.ExtraBold)
)