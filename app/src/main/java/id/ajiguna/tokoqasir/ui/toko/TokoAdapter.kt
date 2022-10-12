package id.ajiguna.tokoqasir.ui.toko

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.ajiguna.tokoqasir.databinding.ItemsProductBinding
import id.ajiguna.tokoqasir.source.toko.Product
import timber.log.Timber

class TokoAdapter(
    val product: ArrayList<Product>,
    val listener: OnAdapterListener
): RecyclerView.Adapter<TokoAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemsProductBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Product){
            binding.product = product
        }
    }

    interface OnAdapterListener{
        fun onClick(product: Product)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= ViewHolder (
        ItemsProductBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = product[position]
        holder.bind(product)
        holder.itemView.setOnClickListener {
            listener.onClick(product)
        }
    }

    override fun getItemCount() = product.size

    fun add(data: List<Product>) {
        product.clear()
        product.addAll(data)
        notifyDataSetChanged()
    }
}