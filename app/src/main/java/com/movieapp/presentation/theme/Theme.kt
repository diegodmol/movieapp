package com.movieapp.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

// App é "dark-first" por natureza (experiência de cinema), mas mantemos
// um fallback claro coerente caso o sistema force light mode.
private val DarkColors = darkColorScheme(
    primary = CinemaGold,
    onPrimary = CinemaBlack,
    secondary = CinemaRed,
    onSecondary = CinemaCream,
    background = CinemaBlack,
    onBackground = CinemaCream,
    surface = CinemaSurface,
    onSurface = CinemaCream,
    surfaceVariant = CinemaSurfaceElevated,
    onSurfaceVariant = CinemaGrayLight,
    error = CinemaError,
    outline = CinemaGray
)

private val LightColors = lightColorScheme(
    primary = CinemaGoldMuted,
    onPrimary = Color_White,
    secondary = CinemaRed,
    onSecondary = Color_White,
    background = Color_White,
    onBackground = CinemaBlack,
    surface = Color_White,
    onSurface = CinemaBlack,
    surfaceVariant = Color_LightGray,
    onSurfaceVariant = CinemaGray,
    error = CinemaError
)

@Composable
fun MovieAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColors else LightColors
    val view = LocalView.current

    if (!view.isInEditMode) {
        androidx.compose.runtime.SideEffect {
            val window = (view.context as android.app.Activity).window
            window.statusBarColor = colorScheme.background.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = MovieTypography,
        content = content
    )
}
