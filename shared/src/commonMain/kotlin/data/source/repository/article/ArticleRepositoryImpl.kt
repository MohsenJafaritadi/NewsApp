package data.source.repository.article

import Utils.error.Failure
import arrow.core.Either
import data.source.model.ArticleModel
import data.source.remote.model.dto.toArticle
import data.source.remote.service.article.ArticleService

class ArticleRepositoryImpl(private val articleService: ArticleService) : ArticleRepository {
    override suspend fun getArticle(
        queryKey: String,
        from: String,
        sortBy: String,
    ): Either<Failure.NetworkFailure, List<ArticleModel>> {

        return articleService.getArticle(
            queryKey, from, sortBy
        )
            .map {

                it.map { it.toArticle() }
            }

    }


}