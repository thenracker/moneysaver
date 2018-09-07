package cz.weissar.moneysaver

import android.app.Application
import com.raizlabs.android.dbflow.config.FlowConfig
import com.raizlabs.android.dbflow.config.FlowManager

class MoneySaverApp : Application() {

    override fun onCreate() {
        super.onCreate()
        FlowManager.init(FlowConfig.Builder(this).build()) //dbflow init
    }

    override fun onTerminate() {
        super.onTerminate()
        FlowManager.destroy() //dbflow destroy
    }
}