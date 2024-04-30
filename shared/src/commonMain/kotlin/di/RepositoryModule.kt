package di

import data.source.repository.article.ArticleRepository
import data.source.repository.article.ArticleRepositoryImpl
import io.ktor.http.auth.HttpAuthHeader
import org.koin.core.module.Module
import org.koin.dsl.module


val repositoryModule = module {
    single<ArticleRepository> {
        ArticleRepositoryImpl(get())
    }
}
