package org.example.kmpbase.presentation.post

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.example.kmpbase.core.domain.usecase.GetPostsUseCase

class PostViewModel(
    private val getPostsUseCase: GetPostsUseCase
) {
    private val viewModelScope = CoroutineScope(Dispatchers.Default)

    private val _uiState = MutableStateFlow<PostUiState>(PostUiState.Loading)
    val uiState: StateFlow<PostUiState> = _uiState

    init {
        fetchPosts()
    }

    private fun fetchPosts() {
        viewModelScope.launch {
            try {
                val posts = getPostsUseCase()
                _uiState.value = PostUiState.Success(posts)
            } catch (e: Exception) {
                _uiState.value = PostUiState.Error(e.message ?: "Erro desconhecido")
            }
        }
    }
}