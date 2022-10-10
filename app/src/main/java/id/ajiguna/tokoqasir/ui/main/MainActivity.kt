package id.ajiguna.tokoqasir.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.ajiguna.tokoqasir.databinding.ActivityMainBinding
import org.koin.dsl.module

val mainModule = module {
    factory { MainActivity() }
}
class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}