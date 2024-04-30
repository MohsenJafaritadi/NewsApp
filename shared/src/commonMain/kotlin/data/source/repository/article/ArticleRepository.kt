package data.source.repository.article

import Utils.error.Failure
import arrow.core.Either
import data.source.model.ArticleModel
import data.source.remote.model.dto.ArticleDto

interface ArticleRepository {

suspend fun getArticle(queryKey:String,from:String,sortBy:String): Either<Failure.NetworkFailure, List<ArticleModel>>
}