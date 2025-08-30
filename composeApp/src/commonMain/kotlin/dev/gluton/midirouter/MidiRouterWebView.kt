package dev.gluton.midirouter

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.multiplatform.webview.web.WebView
import com.multiplatform.webview.web.WebViewFileReadType
import com.multiplatform.webview.web.rememberWebViewStateWithHTMLFile
import midirouterapp.composeapp.generated.resources.Res

@Composable
fun MidiRouterWebView(
    modifier: Modifier = Modifier,
) {
    val webViewState = rememberWebViewStateWithHTMLFile(
        fileName = Res.getUri("files/midi_router/index.html"),
        readType = WebViewFileReadType.COMPOSE_RESOURCE_FILES,
    ).apply {
        webSettings.androidWebSettings.allowMidiSysexMessages = true
    }

    WebView(
        state = webViewState,
        captureBackPresses = false,
        modifier = modifier then Modifier.fillMaxSize(),
    )
}
