package org.example.kmpbase.core.di

import io.ktor.client.HttpClient
import org.example.kmpbase.core.data.api.PostApi
import org.example.kmpbase.core.data.repository.PostRepositoryImpl
import org.example.kmpbase.core.domain.repository.PostRepository
import org.example.kmpbase.core.domain.usecase.GetPostsUseCase
import org.koin.core.module.Module
import org.koin.dsl.module

fun coreModule(httpClient: HttpClient): Module = module {
    single { PostApi(httpClient) }
    single<PostRepository> { PostRepositoryImpl(get()) }
    single { GetPostsUseCase(get()) }
}
