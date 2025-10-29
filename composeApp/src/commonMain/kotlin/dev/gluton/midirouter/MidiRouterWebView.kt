package dev.gluton.midirouter

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.intl.PlatformLocale
import com.multiplatform.webview.web.NativeWebView
import com.multiplatform.webview.web.WebView
import com.multiplatform.webview.web.WebViewState

@Composable
fun MidiRouterWebView(
    modifier: Modifier = Modifier,
) {
    val webViewState = rememberWebViewStateFromHTMLFile("files/midi_router/index.html").apply {
        webSettings.androidWebSettings.allowMidiSysexMessages = true
    }

    WebView(
        state = webViewState,
        captureBackPresses = false,
        modifier = modifier,
        onCreated = ::setupNativeWebView
    )
}

@Composable
expect fun rememberWebViewStateFromHTMLFile(path: String): WebViewState

expect fun setupNativeWebView(nativeWebView: NativeWebView)
