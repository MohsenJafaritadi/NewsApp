package presentation.screen.navigation

import BottomNav
import androidx.compose.runtime.Composable

import com.arkivanov.decompose.router.stack.replaceCurrent
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import io.github.xxfast.decompose.router.Router
import io.github.xxfast.decompose.router.content.RoutedContent
import io.github.xxfast.decompose.router.rememberRouter
import presentation.screen.navigation.article.componet.ArticleScreen

@Composable
fun AppNavigation() {

    val router: Router<BaseNavigation> =
        rememberRouter(BaseNavigation::class, stack = listOf(BaseNavigation.Main))

    RoutedContent(
        router = router,
    ) { screen ->
        when (screen) {
            BaseNavigation.Main -> {
                MainScreen()
            }


            BaseNavigation.Article -> {
                ArticleScreen()
            }

        }
    }


    BottomNav(onMainClick ={ router.replaceCurrent(BaseNavigation.Main)}, onArticleClick ={ router.replaceCurrent(BaseNavigation.Article)})
}

@Parcelize
sealed class BaseNavigation : Parcelable {
    @Parcelize object Article : BaseNavigation()
    @Parcelize object Main : BaseNavigation()
}