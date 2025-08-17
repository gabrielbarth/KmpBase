package org.example.kmpbase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.example.kmpbase.di.initKoinApp
import org.example.kmpbase.presentation.post.PostViewModel
import org.koin.mp.KoinPlatform.getKoin

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        initKoinApp()

        setContent {
            PostScreen()
        }
    }
}

//@Preview
//@Composable
//fun AppAndroidPreview() {
////    PostScreen()
//}