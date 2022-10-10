package id.ajiguna.tokoqasir.appication

import android.app.Application
import id.ajiguna.tokoqasir.source.network.netwrorkModule
import id.ajiguna.tokoqasir.source.toko.repositoryModule
import id.ajiguna.tokoqasir.ui.detail.detailModule
import id.ajiguna.tokoqasir.ui.main.mainModule
import id.ajiguna.tokoqasir.ui.main.mainViewModule
import id.ajiguna.tokoqasir.ui.splash.splashModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class TokoApp: Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        Timber.e("run base application")
        startKoin {
            androidLogger()
            androidContext(this@TokoApp)
            modules(
                netwrorkModule,
                repositoryModule,
                splashModule,
                mainModule,
                mainViewModule,
                detailModule
            )
        }
    }
}