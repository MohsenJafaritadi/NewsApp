package data.source.remote.service.article

import Utils.error.Failure
import arrow.core.Either
import data.source.remote.KtorClient
import data.source.remote.makeRequest
import data.source.remote.model.dto.ArticleDto
import io.ktor.client.request.parameter
import io.ktor.http.HttpMethod
import io.ktor.http.URLBuilder
import io.ktor.http.parametersOf
import io.ktor.http.path
import org.koin.core.parameter.parametersOf


class ArticleServiceImpl(
    private val ktorClient: KtorClient,
) : ArticleService {
    override suspend fun getArticle(

        querykey: String,
        from: String,
        sortBy: String,
    ): Either<Failure.NetworkFailure, List<ArticleDto>> {
        return ktorClient.makeRequest(

            urlBuilder = URLBuilder(
                urlString = "https://newsapi.org/v2/"
            ).apply {
                path("everything")
//                parametersOf("q=tesla&from=2024-03-24&sortBy=publishedAt")

            }, methodType = HttpMethod.Get
        ) {

            parameter("queryKey", querykey)
            parameter("from", from)
            parameter("sortBy", sortBy)
        }
    }
}