package org.example.kmpbase.core.domain.usecase

import org.example.kmpbase.core.domain.model.Post
import org.example.kmpbase.core.domain.repository.PostRepository

class GetPostsUseCase(private val repository: PostRepository) {
    suspend operator fun invoke(): List<Post> = repository.getPosts()
}