package org.example.kmpbase

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import org.example.kmpbase.presentation.post.PostUiState
import org.example.kmpbase.presentation.post.PostViewModel
import org.koin.mp.KoinPlatform.getKoin

@Composable
fun PostScreen(viewModel: PostViewModel = getKoin().get<PostViewModel>()) {
    val state by viewModel.uiState.collectAsState()

    when (state) {
        is PostUiState.Loading -> Text("Carregando...")
        is PostUiState.Error -> Text("Erro: ${(state as PostUiState.Error).message}")
        is PostUiState.Success -> {
            val posts = (state as PostUiState.Success).posts
            LazyColumn {
                items(posts) { post ->
                    Text(post.title)
                }
            }
        }
    }
}