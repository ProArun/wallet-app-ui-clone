package com.arun.walletappuiclone

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arun.walletappuiclone.ui.theme.WalletAppUICloneTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WalletAppUICloneTheme {
                val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(
                    state = rememberTopAppBarState()
                )

                Scaffold(
                    modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
                    topBar = {
                        TopBar(
                            modifier = Modifier.fillMaxWidth(),
                            scrollBehavior = scrollBehavior
                        )
                    }
                ) { paddingValues ->
                    MainScreen(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues)
                    )
                }
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {

        Spacer(modifier = Modifier.height(100.dp))

        CardSection(
            modifier = Modifier
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        ActionSection(modifier = Modifier.fillMaxWidth())

        Spacer(modifier = Modifier.height(40.dp))

        SpendingSection(modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(40.dp))

        SpendingStatisticsSection(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 22.dp)
        )
        Spacer(modifier = Modifier.height(100.dp))

    }
}

fun randomColor(minBrightness: Int = 80): Color {
    val random = Random.Default
    val red = random.nextInt(minBrightness, 256)
    val green = random.nextInt(minBrightness, 256)
    val blue = random.nextInt(minBrightness, 256)
    return Color(red, green, blue)
}