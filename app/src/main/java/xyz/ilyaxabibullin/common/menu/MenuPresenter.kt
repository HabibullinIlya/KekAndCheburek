package xyz.ilyaxabibullin.common.menu

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter

@InjectViewState
class MenuPresenter: MvpPresenter<View>() {
    fun messagesBtnWasClicked() {
//        val VkApi = VkApiRequests()
//        VkApi.getFriends()
        viewState.toFriendsList()
    }

}