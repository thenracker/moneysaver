package cz.weissar.moneysaver.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import cz.weissar.moneysaver.R
import cz.weissar.moneysaver.base.ARG_ITEM_ID
import cz.weissar.moneysaver.ui.fragments.DetailFragment

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_empty)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, DetailFragment.newInstance(intent.getIntExtra(ARG_ITEM_ID, 0)))
                    .commitAllowingStateLoss()
        }
    }
}