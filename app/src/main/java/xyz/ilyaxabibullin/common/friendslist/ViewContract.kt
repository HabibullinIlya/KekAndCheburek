package xyz.ilyaxabibullin.common.friendslist

import com.arellomobile.mvp.MvpView

interface ViewContract:MvpView {
    fun showMessage(msg:String)

    fun showFriendsList(friends: List<Any>)
}