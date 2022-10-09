package id.ajiguna.tokoqasir.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.ajiguna.tokoqasir.R
import org.koin.dsl.module

val mainModule = module {
    factory { MainActivity() }
}
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}