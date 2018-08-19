package xyz.ilyaxabibullin.common.menu

import android.content.Intent
import android.os.Bundle

import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.PresenterType


import kotlinx.android.synthetic.main.activity_main.*
import xyz.ilyaxabibullin.common.R
import xyz.ilyaxabibullin.common.friendslist.FriendsListActivity


open class MenuActivity: MvpAppCompatActivity() ,View{
    @InjectPresenter
    lateinit var presenter: MenuPresenter




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        to_messages_list_btn.setOnClickListener{
            println("kek")
            presenter.messagesBtnWasClicked()
        }
    }

    override fun toFriendsList() {
        var intent = Intent(this, FriendsListActivity::class.java)
        startActivity(intent)
    }

}