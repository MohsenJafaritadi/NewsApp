package di


import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.darwin.Darwin
import org.koin.dsl.module


actual fun dataPlatformModule(context: Any?) = module {

    single<HttpClientEngine> { Darwin.create() }


}