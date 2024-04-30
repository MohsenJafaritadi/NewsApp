package di

import data.source.model.ArticleModel
import data.source.remote.KtorClient
import data.source.remote.service.article.ArticleService
import data.source.remote.service.article.ArticleServiceImpl
import org.koin.core.module.Module
import org.koin.dsl.module
import presentation.screen.navigation.article.componet.ArticleScreen

expect fun dataPlatformModule(context: Any?): Module


val dataModule= module {

    single <ArticleService>{
        ArticleServiceImpl(get())
    }

    single {
        KtorClient(get())
    }

}