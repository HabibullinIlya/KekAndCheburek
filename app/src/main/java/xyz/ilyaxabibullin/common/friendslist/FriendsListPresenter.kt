package xyz.ilyaxabibullin.common.friendslist

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter

@InjectViewState
class FriendsListPresenter: MvpPresenter<ViewContract>() {
    fun activityWasStarted(){
        println("presenter")
        viewState.showMessage("activity was started, mvp works normal")
    }
}