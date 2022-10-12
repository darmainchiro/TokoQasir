package id.ajiguna.tokoqasir.source.toko

import java.io.Serializable

data class TokoModel (
    val record: Record,
    val metadata: Metadata
)

data class Record (
    val data: Data,
    val message: String,
    val status: String
)

data class Data(

    val banner: String,
    val products: List<Product>
)

data class Product(
    val product_id: Int,
    val product_name: String,
    val price: Int,
    val stock: Int,
    val description: String,
    val images: Images,
): Serializable

data class Images(
    val thumbnail: String,
    val large: String
): Serializable

data class Metadata (
    val createdAt: String,
    val jsonMemberPrivate: Boolean,
    val name: String,
    val id: String
)