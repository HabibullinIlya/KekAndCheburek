package xyz.ilyaxabibullin.common

import android.app.Application
import android.content.Context
import com.vk.sdk.VKSdk
import com.vk.sdk.VKAccessToken
import com.vk.sdk.VKAccessTokenTracker
import com.vk.sdk.util.VKUtil



class App: Application(){
    override fun onCreate() {
        super.onCreate()
        val applicationContext = applicationContext
        val fingerprints = VKUtil.getCertificateFingerprint(this, this.packageName)
        VKSdk.initialize(applicationContext)
        vkAccessTokenTracker.startTracking()

    }

    var vkAccessTokenTracker: VKAccessTokenTracker = object : VKAccessTokenTracker() {
        override fun onVKAccessTokenChanged(oldToken: VKAccessToken?, newToken: VKAccessToken?) {
            if (newToken == null) {
                VKSdk.initialize(applicationContext)
            }
        }
    }
    companion object{
        lateinit var accessToken: VKAccessToken
    }


}