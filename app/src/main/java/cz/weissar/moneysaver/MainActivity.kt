package cz.weissar.moneysaver

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState != null) {

            //sayHello("")
        }
    }


    fun sayHello(view: View) {

        val showCountTextView = view as TextView

        val toast = Toast.makeText(this, showCountTextView.text, Toast.LENGTH_SHORT)

        toast.show()

        val intent = Intent(this, MainActivity::class.java)

        startActivity(intent)
    }
}
