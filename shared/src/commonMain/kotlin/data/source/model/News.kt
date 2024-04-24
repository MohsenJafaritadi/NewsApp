package data.source.model


import data.source.remote.model.dto.ArticleDto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class News(
    @SerialName("articles")
    val articles: List<ArticleDto>,
    @SerialName("status")
    val status: String,
    @SerialName("totalResults")
    val totalResults: Int
)