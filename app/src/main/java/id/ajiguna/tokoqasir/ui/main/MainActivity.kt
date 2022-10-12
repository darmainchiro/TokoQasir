package id.ajiguna.tokoqasir.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import id.ajiguna.tokoqasir.R
import id.ajiguna.tokoqasir.databinding.ActivityMainBinding
import id.ajiguna.tokoqasir.source.toko.Product
import id.ajiguna.tokoqasir.ui.detail.DetailActivity
import id.ajiguna.tokoqasir.ui.toko.TokoAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.dsl.module
import timber.log.Timber

val mainModule = module {
    factory { MainActivity() }
}
class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        binding.rvProduct.adapter = tokoAdapter
        viewModel.toko.observe(this) {
            Timber.e(it.record.data.products.toString())
            tokoAdapter.add(it.record.data.products)
            Glide.with(this)
                .load(it.record.data.banner)
                .placeholder(R.drawable.ic_loading)
                .error(R.drawable.ic_error)
                .into(binding.ivBanner)
        }


    }

    private val tokoAdapter by lazy {
        TokoAdapter(arrayListOf(), object : TokoAdapter.OnAdapterListener {
            override fun onClick(product: Product) {
                startActivity(
                    Intent(this@MainActivity, DetailActivity::class.java)
                        .putExtra("detail", product)
                )
            }
        })
    }
}