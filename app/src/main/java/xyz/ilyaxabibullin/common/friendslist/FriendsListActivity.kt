package xyz.ilyaxabibullin.common.friendslist

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.PresenterType
import kotlinx.android.synthetic.main.recycler_view.*
import xyz.ilyaxabibullin.common.R

class FriendsListActivity: MvpAppCompatActivity(),ViewContract {


    @InjectPresenter
    lateinit var presenter: FriendsListPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recycler_view)

        presenter.activityWasStarted()

    }

    override fun showMessage(msg: String) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
    }





}