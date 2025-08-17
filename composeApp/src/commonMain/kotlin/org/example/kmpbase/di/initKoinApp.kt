package org.example.kmpbase.di

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.example.kmpbase.core.data.api.PostApi
import org.example.kmpbase.core.data.repository.PostRepositoryImpl
import org.example.kmpbase.core.domain.usecase.GetPostsUseCase
import org.example.kmpbase.presentation.post.PostViewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

fun initKoinApp() {
    startKoin {
        printLogger()
        modules(
            coreModule,
            presentationModule
        )
    }
}

// Koin modules
val coreModule = module {
    single { provideHttpClient() }
    single<PostApi> { PostApi(get()) }
    single { PostRepositoryImpl(get()) }
    single { GetPostsUseCase(get()) }
}

val presentationModule = module {
    single { PostViewModel(get()) }
}

// Provedor de HttpClient (poderia ser multiplataforma se quiser usar darwin no iOS)
fun provideHttpClient(): HttpClient = HttpClient {
    install(ContentNegotiation) {
        json(Json {
            ignoreUnknownKeys = true
        })
    }
}