package at.willhaben.multiscreenflow

import android.app.Application
import android.content.Context
import android.os.StrictMode



class App : Application() {

    override fun onCreate() {
        super.onCreate()
        StrictMode.setVmPolicy(
            StrictMode.VmPolicy.Builder()
                .detectActivityLeaks()
                .penaltyLog()
                .build()
        )

        CONTEXT = this
    }

    companion object {
        lateinit var CONTEXT : Context
    }
}