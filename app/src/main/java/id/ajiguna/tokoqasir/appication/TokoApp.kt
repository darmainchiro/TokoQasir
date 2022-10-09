package id.ajiguna.tokoqasir.appication

import android.app.Application
import id.ajiguna.tokoqasir.source.network.netwrorkModule
import id.ajiguna.tokoqasir.ui.main.mainModule
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
                mainModule,
            )
        }
    }
}