package dev.gluton.midirouter

import androidx.compose.runtime.Composable
import com.multiplatform.webview.web.NativeWebView
import com.multiplatform.webview.web.WebViewFileReadType
import com.multiplatform.webview.web.WebViewState
import com.multiplatform.webview.web.rememberWebViewStateWithHTMLFile
import midirouterapp.composeapp.generated.resources.Res

@Composable
actual fun rememberWebViewStateFromHTMLFile(path: String): WebViewState {
    return rememberWebViewStateWithHTMLFile(
        fileName = Res.getUri(path),
        readType = WebViewFileReadType.COMPOSE_RESOURCE_FILES,
    )
}

actual fun setupNativeWebView(nativeWebView: NativeWebView) {}
