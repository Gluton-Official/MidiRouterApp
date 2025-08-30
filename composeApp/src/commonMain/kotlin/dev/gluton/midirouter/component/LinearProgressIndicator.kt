package dev.gluton.midirouter.component

import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.gluton.midirouter.theme.MidiRouterTheme

@Composable
fun MidiRouterLinearProgressIndicator(
    progress: () -> Float,
    modifier: Modifier = Modifier,
    color: Color = MidiRouterTheme.colors.accent,
    trackColor: Color = MidiRouterTheme.colors.text,
    gapSize: Dp = 0.dp,
    drawStopIndicator: DrawScope.() -> Unit = {},
) = LinearProgressIndicator(
    progress = progress,
    modifier = modifier,
    color = color,
    trackColor = trackColor,
    gapSize = gapSize,
    drawStopIndicator = drawStopIndicator,
)
