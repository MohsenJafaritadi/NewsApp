package presentation.screen.navigation.article.componet

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import io.github.xxfast.decompose.router.Router
import org.koin.compose.koinInject
import presentation.viewModel.ArticleViewModel
import presentation.viewModel.Utils.state

@Composable
fun ArticleScreen(

    viewModel: ArticleViewModel = koinInject(),
) {

        Column(
            modifier = androidx.compose.ui.Modifier
                .padding(bottom = 74.dp)
                .fillMaxSize()

        ) {
          if (viewModel.state().value.articles.isNotEmpty()){

                ArticleList(viewModel.state().value.articles)

        }
    }

}