package id.ajiguna.tokoqasir.source.toko

import id.ajiguna.tokoqasir.source.network.ApiClient
import org.koin.dsl.module

val repositoryModule = module {
    factory { TokoRepository(get()) }
}

class TokoRepository(
    private val api: ApiClient
) {

    suspend fun fetch(): TokoModel{
        return api.fetchProduct()
    }
}