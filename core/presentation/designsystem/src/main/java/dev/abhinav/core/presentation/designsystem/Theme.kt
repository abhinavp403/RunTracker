package dev.abhinav.core.presentation.designsystem

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

val DarkColorScheme = darkColorScheme(
    primary = RuntrackerGreen,
    background = RuntrackerBlack,
    surface = RuntrackerDarkGray,
    secondary = RuntrackerWhite,
    tertiary = RuntrackerWhite,
    primaryContainer = RuntrackerGreen30,
    onPrimary = RuntrackerBlack,
    onBackground = RuntrackerWhite,
    onSurface = RuntrackerWhite,
    onSurfaceVariant = RuntrackerGray,
    error = RuntrackerDarkRed,
    errorContainer = RuntrackerDarkRed5
)

@Composable
fun RuntrackerTheme(
    content: @Composable () -> Unit
) {
    val colorScheme = DarkColorScheme
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = false
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}