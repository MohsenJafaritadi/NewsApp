package data.source.remote.model.dto


import data.source.model.ArticleModel
import data.source.model.Source
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArticleDto(
    @SerialName("author")
    val author: String,
    @SerialName("content")
    val content: String,
    @SerialName("description")
    val description: String,
    @SerialName("publishedAt")
    val publishedAt: String,
    @SerialName("source")
    val source: Source,
    @SerialName("title")
    val title: String,
    @SerialName("url")
    val url: String,
    @SerialName("urlToImage")
    val urlToImage: String
)
fun ArticleDto.toArticle(): ArticleModel {

    return ArticleModel(
        description = description,
        title =  title,
        urlToImage = urlToImage

    )
}