package dev.gluton.midirouter.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import midirouterapp.composeapp.generated.resources.Res
import midirouterapp.composeapp.generated.resources.m8stealth57
import org.jetbrains.compose.resources.Font

private val M8Stealth57: FontFamily
    @Composable
    get() = FontFamily(
        Font(Res.font.m8stealth57)
    )

val MidiRouterTypography: Typography
    @Composable
    get() = with(MaterialTheme.typography) {
        Typography(
            displayLarge = displayLarge.copy(fontFamily = M8Stealth57),
            displayMedium = displayMedium.copy(fontFamily = M8Stealth57),
            displaySmall = displaySmall.copy(fontFamily = M8Stealth57),
            headlineLarge = headlineLarge.copy(fontFamily = M8Stealth57),
            headlineMedium = headlineMedium.copy(fontFamily = M8Stealth57),
            headlineSmall = headlineSmall.copy(fontFamily = M8Stealth57),
            titleLarge = titleLarge.copy(fontFamily = M8Stealth57),
            titleMedium = titleMedium.copy(fontFamily = M8Stealth57),
            titleSmall = titleSmall.copy(fontFamily = M8Stealth57),
            bodyLarge = bodyLarge.copy(fontFamily = M8Stealth57),
            bodyMedium = bodyMedium.copy(fontFamily = M8Stealth57),
            bodySmall = bodySmall.copy(fontFamily = M8Stealth57),
            labelLarge = labelLarge.copy(fontFamily = M8Stealth57),
            labelMedium = labelMedium.copy(fontFamily = M8Stealth57),
            labelSmall = labelSmall.copy(fontFamily = M8Stealth57),
        )
    }
