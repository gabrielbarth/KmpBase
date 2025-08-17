package org.example.kmpbase.core.data.api

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import org.example.kmpbase.core.data.PostDTO

class PostApi(private val client: HttpClient) {
    suspend fun getPosts(): List<PostDTO> {
        val response: HttpResponse = client.get("https://jsonplaceholder.typicode.com/posts")
        return response.body()
    }
}