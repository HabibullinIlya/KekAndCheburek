package xyz.ilyaxabibullin.common

import android.app.Activity
import android.content.Intent

import android.os.Bundle
import com.vk.sdk.VKScope
import com.vk.sdk.VKSdk
import com.vk.sdk.util.VKUtil


import com.vk.sdk.api.VKError
import com.vk.sdk.VKAccessToken
import com.vk.sdk.VKCallback
import xyz.ilyaxabibullin.common.menu.MenuActivity


class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash)
        val fingerprints = VKUtil.getCertificateFingerprint(this, this.packageName)

        println("fingerprints = ${fingerprints[0]}")
        VKSdk.login(this, VKScope.MESSAGES)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (!VKSdk.onActivityResult(requestCode, resultCode, data, object : VKCallback<VKAccessToken> {
              override fun onResult(res: VKAccessToken) {
                  App.accessToken = res
                  val intent = Intent(this@MainActivity, MenuActivity::class.java)
                  startActivity(intent)
                  this@MainActivity.finish()
              }
              override fun onError(error: VKError) {

              }
            })) {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}
