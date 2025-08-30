package dev.gluton.midirouter

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.gluton.midirouter.theme.MidiRouterTheme

@Composable
fun MidiRouterApp() {
    MidiRouterTheme {
        Scaffold(
            topBar = {
//                @OptIn(ExperimentalMaterial3Api::class)
//                CenterAlignedTopAppBar(
//                    title = {
//                        Text("MIDI ROUTER")
//                    },
//                    colors = TopAppBarColors(
//                        containerColor = MidiRouterTheme.colors.background,
//                        scrolledContainerColor = MidiRouterTheme.colors.background,
//                        navigationIconContentColor = MidiRouterTheme.colors.text,
//                        titleContentColor = MidiRouterTheme.colors.accent,
//                        actionIconContentColor = MidiRouterTheme.colors.text,
//                    )
//                )
            },
            containerColor = MidiRouterTheme.colors.background,
            contentColor = MidiRouterTheme.colors.text,
        ) {
            MidiRouterWebView(modifier = Modifier.padding(it))
        }
    }
}
