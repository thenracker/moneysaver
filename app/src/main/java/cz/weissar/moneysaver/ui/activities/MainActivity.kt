package cz.weissar.moneysaver.ui.activities

import android.arch.lifecycle.Observer
//import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import cz.weissar.moneysaver.R
import cz.weissar.moneysaver.db.model.ItemEntity
import cz.weissar.moneysaver.koin.MainActivityPresenter
import cz.weissar.moneysaver.ui.fragments.MainFragment
import cz.weissar.moneysaver.viewmodels.MyViewModel
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val presenter: MainActivityPresenter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_empty)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(R.id.container, MainFragment.newInstance()).commitAllowingStateLoss()
        }

        Toast.makeText(this, presenter.sayHello(), Toast.LENGTH_SHORT).show()

        /*
        val model = ViewModelProviders.of(this).get(MyViewModel::class.java)
        model.getItems().observe(this, Observer<List<ItemEntity>> { items ->
            // updateUI - TODO
        })
        */
    }

}
