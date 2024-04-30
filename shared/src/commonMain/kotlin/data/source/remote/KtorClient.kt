package data.source.remote

import Utils.error.Failure
import Utils.error.Failure.NetworkFailure
import arrow.core.Either
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.parameter
import io.ktor.client.request.request
import io.ktor.http.HttpMethod
import io.ktor.http.URLBuilder
import io.ktor.serialization.kotlinx.json.json

class KtorClient(
    engine: HttpClientEngine,
) {

    val client= HttpClient(engine){





        install(ContentNegotiation) {
            json(kotlinx.serialization.json.Json {

                ignoreUnknownKeys = true
            })
        }
        install(Logging) {
            logger = object : Logger {
                override fun log(message: String) {
                    println(message)
                }
            }
            level = LogLevel.ALL

        }

    }



}

suspend inline fun <reified T : Any> KtorClient.makeRequest(
    urlBuilder: URLBuilder,
    methodType: HttpMethod = io.ktor.http.HttpMethod.Get,
    toAppendHeaders: List<Pair<String, String>> = emptyList(),
    noinline body: (HttpRequestBuilder.() -> Unit)? = null
): Either<NetworkFailure, T> {
    return try {
        arrow.core.Either.Right(
            this.client.request(
                url = urlBuilder.build()
            ) {
                method = methodType

                parameter("apikey","61a23b022e4f4e2e988fdfffaaf973fd")

                toAppendHeaders.forEach { (key, value) ->
                    headers.append(key, value)
                }
                body?.let { it() }
            }.body()
        )

    }catch (exception: Exception) {
        Either.Left(Failure.NetworkFailure.UnknownException(exception))
    }
}