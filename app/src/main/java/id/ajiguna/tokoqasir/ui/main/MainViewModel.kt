package id.ajiguna.tokoqasir.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.ajiguna.tokoqasir.source.toko.TokoModel
import id.ajiguna.tokoqasir.source.toko.TokoRepository
import kotlinx.coroutines.launch
import org.koin.dsl.module

val mainViewModule = module {
    factory { MainViewModel(get()) }
}

class MainViewModel(val tokoRepository: TokoRepository): ViewModel() {

    val message by lazy { MutableLiveData<String>() }
    val toko by lazy { MutableLiveData<TokoModel>() }

    init {
        message.value = null
        fetch()
    }

    fun fetch() {
        viewModelScope.launch {
            try {
                val response = tokoRepository.fetch()
                toko.value = response
            } catch (e: Exception){
                message.value = "Terjadi kesalahan"
            }
        }
    }

}