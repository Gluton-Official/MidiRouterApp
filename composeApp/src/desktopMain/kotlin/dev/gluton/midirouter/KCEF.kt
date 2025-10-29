package dev.gluton.midirouter

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.datlag.kcef.KCEF
import dev.gluton.midirouter.component.MidiRouterButton
import dev.gluton.midirouter.component.MidiRouterLinearProgressIndicator
import dev.gluton.midirouter.component.MidiRouterText
import dev.gluton.midirouter.theme.MidiRouterTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import kotlin.math.max

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun KCEF(
    onRestart: () -> Unit,
    content: @Composable () -> Unit = {},
) {
    var restartRequired by remember { mutableStateOf(false) }
    var downloadProgress by remember { mutableStateOf(0f) }
    var initialized by remember { mutableStateOf(false) }
    val bundleLocation = System.getProperty("compose.application.resources.dir")?.let(::File)

    LaunchedEffect(Unit) {
        withContext(Dispatchers.IO) {
            KCEF.init(
                builder = {
//                    addArgs(
//                        "--use-fake-ui-for-media-stream",
//                        "--disable-permissions-api"
//                    )

                    installDir(File(bundleLocation, "kcef-bundle"))

                    progress {
                        onDownloading {
                            downloadProgress = max(it, 0f)
                        }
                        onInitialized {
                            initialized = true
                        }
                    }

                    settings {
                        cachePath = File(bundleLocation, "cache").absolutePath
                         remoteDebuggingPort = 8080
                    }
                },
                onError = {
                    println("Failed to initialize KCEF")
                    it?.printStackTrace()
                },
                onRestartRequired = {
                    restartRequired = true
                }
            )
        }
    }

    val loaded = initialized && !restartRequired

    if (loaded) {
        content()
    } else {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
            modifier = Modifier.fillMaxSize().background(MidiRouterTheme.colors.background),
        ) {
            if (restartRequired) {
                MidiRouterText("Restart required")
                MidiRouterButton(onClick = onRestart) {
                    Text("Close")
                }
            } else {
                val animatedDownloadProgress by animateFloatAsState(
                    downloadProgress,
                    animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec,
                )

                MidiRouterText("Downloading KCEF... ${downloadProgress.toInt()}%")
                MidiRouterLinearProgressIndicator(
                    progress = { animatedDownloadProgress / 100f },
                    modifier = Modifier.width(320.dp),
                )
            }
        }
    }

    DisposableEffect(Unit) {
        onDispose {
            KCEF.disposeBlocking()
        }
    }
}

fun Int.hasPermissions(permissions: Int): Boolean = (this and permissions) != 0
