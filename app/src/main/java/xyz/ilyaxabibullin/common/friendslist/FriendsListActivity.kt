package xyz.ilyaxabibullin.common.friendslist

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.support.v7.widget.SearchView
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.PresenterType
import kotlinx.android.synthetic.main.recycler_view.*
import kotlinx.android.synthetic.main.toolbar.*
import xyz.ilyaxabibullin.common.R

class FriendsListActivity: MvpAppCompatActivity(),ViewContract {

    @InjectPresenter
    lateinit var presenter: FriendsListPresenter


    lateinit var mActionBar:Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recycler_view)
        initActivity()



        presenter.activityWasStarted()

    }

    override fun showMessage(msg: String) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
    }

    override fun showFriendsList(friends: List<Any>) {

    }

    private fun initActivity(){
        setSupportActionBar(toolbar_actionbar)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
       return when (item!!.itemId){
           android.R.id.home->{
               this.finish()
               true
           }
           else -> super.onOptionsItemSelected(item)
       }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu);
        val mSearch = menu!!.findItem(R.id.action_search)
        val searchView = mSearch.actionView as SearchView

        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                Toast.makeText(this@FriendsListActivity,p0,Toast.LENGTH_SHORT).show()
                return true
            }

        })
        return true
    }




}