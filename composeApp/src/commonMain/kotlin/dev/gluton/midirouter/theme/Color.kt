package dev.gluton.midirouter.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

val Accent = Color(0xff32ecff)
val Background = Color.Black
val Text = Color(0xff808080)

@Immutable
data class MidiRouterColors(
    val accent: Color = Accent,
    val background: Color = Background,
    val text: Color = Text,
)
