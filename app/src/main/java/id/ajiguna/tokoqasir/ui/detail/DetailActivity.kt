package id.ajiguna.tokoqasir.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.ajiguna.tokoqasir.databinding.ActivityDetailBinding
import org.koin.dsl.module

val detailModule = module {
    factory { DetailActivity() }
}

class DetailActivity : AppCompatActivity(){

    private val binding by lazy { ActivityDetailBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}