package cz.weissar.moneysaver.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import cz.weissar.moneysaver.R
import cz.weissar.moneysaver.ui.fragments.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(R.id.container, MainFragment.newInstance()).commitAllowingStateLoss()
        }
    }

}
