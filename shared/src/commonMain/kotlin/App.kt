import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.material.Button

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import di.dataModule
import di.dataPlatformModule
import di.repositoryModule

import di.viewModelModule
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.koin.compose.KoinApplication

import presentation.screen.navigation.AppNavigation


@OptIn(ExperimentalResourceApi::class)
@Composable
fun App(context: Any? = null) {
    KoinApplication(application = {
        modules(dataPlatformModule(context), dataModule, repositoryModule, viewModelModule)
    }) {


        MaterialTheme {
            AppNavigation()
        }
    }
}


@Composable
fun BottomNav(onMainClick: () -> Unit, onArticleClick: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.SpaceAround
    ) {

        Button(onClick = {
            onMainClick()
        }) {
            Column {
                Icons.Default.Home
                Text("Home")
            }
        }

        Button(onClick = {
            onArticleClick()
        }) {
            Icons.Default.Star
            Text("Article")
        }
    }
}

expect fun getPlatformName(): String