package di


import io.ktor.client.engine.HttpClientEngine

import org.koin.dsl.module

import io.ktor.client.engine.okhttp.OkHttp


actual fun dataPlatformModule(context: Any?) = module {

    single<HttpClientEngine> {
        OkHttp.create()
    }



}