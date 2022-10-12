package id.ajiguna.tokoqasir.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import id.ajiguna.tokoqasir.R
import id.ajiguna.tokoqasir.databinding.ActivityDetailBinding
import id.ajiguna.tokoqasir.source.toko.Product
import org.koin.dsl.module
import java.text.NumberFormat
import java.util.*

val detailModule = module {
    factory { DetailActivity() }
}

class DetailActivity : AppCompatActivity(){

    private val binding by lazy { ActivityDetailBinding.inflate(layoutInflater) }
    private val detail by lazy {
        intent.getSerializableExtra("detail") as Product
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //actionbar
        val actionbar = supportActionBar
        actionbar?.setHomeButtonEnabled(true)
        actionbar?.setDisplayHomeAsUpEnabled(true)

        detail.let {
            supportActionBar?.title = it.product_name
            binding.tvItemTitle.text = it.product_name
            binding.tvPrice.text = "Rp " + NumberFormat.getInstance().format(it.price)
            binding.tvDescription.text = it.description
            Glide.with(this)
                .load(it.images.large)
                .placeholder(R.drawable.ic_loading)
                .error(R.drawable.ic_error)
                .into(binding.ivProduct)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
}