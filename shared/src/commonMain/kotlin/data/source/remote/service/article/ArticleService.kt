package data.source.remote.service.article

import Utils.error.Failure
import arrow.core.Either
import data.source.remote.model.dto.ArticleDto

interface ArticleService  {
suspend fun getArticle(queryKey:String,from:String,sortBy:String): Either<Failure.NetworkFailure,List<ArticleDto>>

}