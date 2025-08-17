package org.example.kmpbase.core.data

import kotlinx.serialization.Serializable
import org.example.kmpbase.core.domain.model.Post

@Serializable
data class PostDTO(
    val id: Int,
    val title: String,
    val body: String
) {
    fun toDomain(): Post = Post(id = id, title = title, body = body)
}