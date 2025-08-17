package org.example.kmpbase.core.data.repository

import org.example.kmpbase.core.data.api.PostApi
import org.example.kmpbase.core.domain.model.Post
import org.example.kmpbase.core.domain.repository.PostRepository

class PostRepositoryImpl(private val api: PostApi) : PostRepository {
    override suspend fun getPosts(): List<Post> {
        return api.getPosts().map { it.toDomain() }
    }
}