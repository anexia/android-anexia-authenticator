package com.twofasapp.designsystem.internal

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.twofasapp.designsystem.R
import com.twofasapp.designsystem.TwTheme

@Immutable
@Stable
class ThemeTypo {

    val h1 = TextStyle(
        fontFamily = FontFamily(
            Font(resId = R.font.fira_sans_regular)
        ),
        fontSize = 42.sp,
        lineHeight = 42.sp,
    )

    val h2 = TextStyle(
        fontFamily = FontFamily(
            Font(resId = R.font.fira_sans_bold)
        ),
        fontSize = 24.sp,
        lineHeight = 32.sp,
    )

    val h3 = TextStyle(
        fontFamily = FontFamily(
            Font(resId = R.font.fira_sans_regular)
        ),
        fontSize = 24.sp,
        lineHeight = 32.sp,
    )

    val title = TextStyle(
        fontFamily = FontFamily(
            Font(resId = R.font.fira_sans_regular)
        ),
        fontSize = 22.sp,
        lineHeight = 26.sp,
    )

    val body1 = TextStyle(
        fontFamily = FontFamily(
            Font(resId = R.font.fira_sans_regular)
        ),
        fontSize = 16.sp,
        lineHeight = 24.sp,
    )

    val body2 = TextStyle(
        fontFamily = FontFamily(
            Font(resId = R.font.fira_sans_medium)
        ),
        fontSize = 14.sp,
        lineHeight = 20.sp,
    )

    val body3 = TextStyle(
        fontFamily = FontFamily(
            Font(resId = R.font.fira_sans_regular)
        ),
        fontSize = 14.sp,
        lineHeight = 17.sp,
    )

    val body4 = TextStyle(
        fontFamily = FontFamily(
            Font(resId = R.font.fira_sans_regular)
        ),
        fontSize = 13.sp,
        lineHeight = 17.sp,
    )

    val caption = TextStyle(
        fontFamily = FontFamily(
            Font(resId = R.font.fira_sans_regular)
        ),
        fontSize = 12.sp,
        lineHeight = 16.sp,
    )

    val subhead = TextStyle(
        fontFamily = FontFamily(
            Font(resId = R.font.fira_sans_medium)
        ),
        fontSize = 12.sp,
        lineHeight = 16.sp,
    )

    val codeExtraLight = TextStyle(
        fontFamily = FontFamily(
            Font(resId = R.font.fira_sans_extra_light)
        ),
        fontSize = 44.sp,
        lineHeight = 44.sp,
    )

    val codeLightSmall = TextStyle(
        fontFamily = FontFamily(
            Font(resId = R.font.fira_sans_light)
        ),
        fontSize = 24.sp,
        lineHeight = 32.sp,
    )

    val codeLight = TextStyle(
        fontFamily = FontFamily(
            Font(resId = R.font.fira_sans_light)
        ),
        fontSize = 44.sp,
        lineHeight = 44.sp,
    )

    val codeThin = TextStyle(
        fontFamily = FontFamily(
            Font(resId = R.font.fira_sans_thin)
        ),
        fontSize = 44.sp,
        lineHeight = 44.sp,
    )
}