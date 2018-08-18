package xyz.ilyaxabibullin.common.messagehistory

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import xyz.ilyaxabibullin.common.R

class FriendsListActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recycler_view)
    }
}