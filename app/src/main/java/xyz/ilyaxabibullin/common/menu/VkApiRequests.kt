package xyz.ilyaxabibullin.common.menu

import com.vk.sdk.api.VKApi
import com.vk.sdk.api.VKParameters
import com.vk.sdk.api.VKRequest
import com.vk.sdk.api.VKResponse

class VkApiRequests{
    fun getFriends(){
        val request = VKApi.friends().get(VKParameters())
        request.executeWithListener(object: VKRequest.VKRequestListener(){
            override fun onComplete(response: VKResponse?) {
                println(response!!.json.toString())

            }
        })
    }
}
