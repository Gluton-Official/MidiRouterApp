package dev.gluton.midirouter

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.multiplatform.webview.util.addTempDirectoryRemovalHook
import dev.gluton.midirouter.theme.MidiRouterTheme

fun main() = application {
    addTempDirectoryRemovalHook()
    Window(
        onCloseRequest = ::exitApplication,
        title = "MidiRouter",
    ) {
        MidiRouterTheme {
            KCEF(onRestart = ::exitApplication) {
                MidiRouterWebView(modifier = Modifier.fillMaxSize())
            }
        }
    }
}
