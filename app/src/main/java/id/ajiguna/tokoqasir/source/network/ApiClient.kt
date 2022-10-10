package id.ajiguna.tokoqasir.source.network

import id.ajiguna.tokoqasir.source.toko.TokoModel
import retrofit2.http.GET

interface ApiClient {
    @GET("b/62f890c4a1610e6386fd2420")
    suspend fun fetchProduct() : TokoModel
}