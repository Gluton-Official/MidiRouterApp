package dev.gluton.midirouter.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Composable
fun MidiRouterTheme(colors: MidiRouterColors = MidiRouterColors(), content: @Composable () -> Unit) {
    ProvideMidiRouterColors(colors) {
        MaterialTheme(
            colorScheme = debugColors(),
            shapes = MidiRouterShapes,
            typography = MidiRouterTypography,
            content = content,
        )
    }
}

object MidiRouterTheme {
    val colors: MidiRouterColors
        @Composable
        get() = LocalMidiRouterColors.current
}

@Composable
fun ProvideMidiRouterColors(colors: MidiRouterColors, content: @Composable () -> Unit) {
    CompositionLocalProvider(LocalMidiRouterColors provides colors, content = content)
}

private val LocalMidiRouterColors = staticCompositionLocalOf { MidiRouterColors() }

fun debugColors(debugColor: Color = Color.Magenta) = ColorScheme(
    primary = debugColor,
    onPrimary = debugColor,
    primaryContainer = debugColor,
    onPrimaryContainer = debugColor,
    inversePrimary = debugColor,
    secondary = debugColor,
    onSecondary = debugColor,
    secondaryContainer = debugColor,
    onSecondaryContainer = debugColor,
    tertiary = debugColor,
    onTertiary = debugColor,
    tertiaryContainer = debugColor,
    onTertiaryContainer = debugColor,
    background = debugColor,
    onBackground = debugColor,
    surface = debugColor,
    onSurface = debugColor,
    surfaceVariant = debugColor,
    onSurfaceVariant = debugColor,
    surfaceTint = debugColor,
    inverseSurface = debugColor,
    inverseOnSurface = debugColor,
    error = debugColor,
    onError = debugColor,
    errorContainer = debugColor,
    onErrorContainer = debugColor,
    outline = debugColor,
    outlineVariant = debugColor,
    scrim = debugColor,
    surfaceBright = debugColor,
    surfaceDim = debugColor,
    surfaceContainer = debugColor,
    surfaceContainerHigh = debugColor,
    surfaceContainerHighest = debugColor,
    surfaceContainerLow = debugColor,
    surfaceContainerLowest = debugColor
)
