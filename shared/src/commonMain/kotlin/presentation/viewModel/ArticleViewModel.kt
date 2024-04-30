package presentation.viewModel

import data.base.BaseViewModel
import data.base.Failed

import data.source.model.ArticleModel
import data.source.remote.model.dto.ArticleDto
import data.source.repository.article.ArticleRepository
import data.source.repository.article.ArticleRepositoryImpl
import kotlinx.coroutines.launch

class ArticleViewModel constructor(val articleRepositoryImpl: ArticleRepositoryImpl) :
    BaseViewModel<ArticleViewModel.State>(State()) {


    data class State(

        val query: String = "tesla",
        val from: String = "2024-03-24",
        val sort: String = "publishedAt",
        val articles: List<ArticleModel> = emptyList(),
        val error: String? = null,
        )

    init {
        getArticle()
    }

//    fun fetchArticles(query: String, from: String, sort: String) {
//        updateState { copy(query = query, from = from, sort = sort) }
//        getArticle()
//    }

    private fun getArticle() {

        viewModelScope.launch {
            articleRepositoryImpl.getArticle(currentState.query, currentState.from, currentState.sort)
                .fold(
                    ifRight = {
                        updateState { copy(articles = articles) }
                    },
                    ifLeft = {
                        updateState {
                            copy(
                                error = it.getErrorMessage()
                            )
                        }

                    }

                )
        }
    }
}