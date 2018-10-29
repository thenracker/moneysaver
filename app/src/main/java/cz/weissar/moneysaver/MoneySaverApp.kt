package cz.weissar.moneysaver

import android.app.Application
import com.raizlabs.android.dbflow.config.FlowConfig
import com.raizlabs.android.dbflow.config.FlowManager
import cz.weissar.moneysaver.koin.appModule
import org.koin.android.ext.android.startKoin

class MoneySaverApp : Application() {

    override fun onCreate() {
        super.onCreate()

        // DBFlow
        FlowManager.init(FlowConfig.Builder(this).build())

        // Start Koin
        startKoin(this, listOf(appModule))

    }

    override fun onTerminate() {
        super.onTerminate()
        FlowManager.destroy() //dbflow destroy
    }
}