package di

import org.koin.dsl.module
import presentation.viewModel.ArticleViewModel

val viewModelModule = module {

    viewModelDefinition {

        ArticleViewModel(get())
    }

}