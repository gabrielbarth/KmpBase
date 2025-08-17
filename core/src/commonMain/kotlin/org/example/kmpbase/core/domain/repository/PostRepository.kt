package org.example.kmpbase.core.domain.repository

import org.example.kmpbase.core.domain.model.Post

interface PostRepository {
    suspend fun getPosts(): List<Post>
}