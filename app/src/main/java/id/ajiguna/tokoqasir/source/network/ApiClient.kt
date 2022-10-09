package id.ajiguna.tokoqasir.source.network

import id.ajiguna.tokoqasir.source.toko.DataResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {
    @GET("b/62f890c4a1610e6386fd2420")
    suspend fun fetchProduct() : DataResponse
}