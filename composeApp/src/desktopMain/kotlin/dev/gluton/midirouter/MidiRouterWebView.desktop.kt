package dev.gluton.midirouter

import androidx.compose.runtime.Composable
import com.multiplatform.webview.web.NativeWebView
import com.multiplatform.webview.web.WebViewState
import com.multiplatform.webview.web.rememberWebViewStateWithHTMLData
import kotlinx.coroutines.runBlocking
import midirouterapp.composeapp.generated.resources.Res
import org.cef.callback.CefMediaAccessCallback
import kotlin.io.path.Path

@Composable
actual fun rememberWebViewStateFromHTMLFile(path: String): WebViewState {
    return rememberWebViewStateWithHTMLData(
        data = runBlocking {
            @Suppress("CheckedExceptionsKotlin")
            Res.readBytes(path).decodeToString().let {
                it.replace("""([\t ]+)<script src="(.+)"></script>""".toRegex()) { matchResult ->
                    val (indent, srcPath) = matchResult.destructured
                    val srcScript = runBlocking {
                        Res.readBytes(Path(path).parent.resolve(Path(srcPath).normalize()).toString().replace('\\', '/')).decodeToString()
                    }
                    "<script>\n${srcScript.prependIndent("    ")}\n</script>".prependIndent(indent)
                }
            }
        }
    )
}

actual fun setupNativeWebView(nativeWebView: NativeWebView) {
    nativeWebView.client.addPermissionHandler { browser, _, _, requestedPermissions, callback ->
        val handlePermissions = requestedPermissions.hasPermissions(CefMediaAccessCallback.MediaPermissionFlags.DEVICE_AUDIO_CAPTURE)
        println("handling permissions ($requestedPermissions): $handlePermissions")
        if (handlePermissions) {
            callback.Continue(requestedPermissions)
        }
        handlePermissions
    }
}
