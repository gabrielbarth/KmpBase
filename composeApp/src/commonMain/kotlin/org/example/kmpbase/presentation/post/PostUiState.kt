package org.example.kmpbase.presentation.post

import org.example.kmpbase.core.domain.model.Post

sealed class PostUiState {
    object Loading : PostUiState()
    data class Success(val posts: List<Post>) : PostUiState()
    data class Error(val message: String) : PostUiState()
}