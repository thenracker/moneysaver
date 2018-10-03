package cz.weissar.moneysaver.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import cz.weissar.moneysaver.R
import cz.weissar.moneysaver.db.Item
import cz.weissar.moneysaver.db.ItemDao
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //private lateinit var recycler: RecyclerView
    private lateinit var items: MutableList<Item>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //recycler = recyclerView
        helloTextView.text = "Klikni na mě"

        initItems()
    }

    private fun initItems() {

        items = ItemDao.getAll()
        val adapter = Adapter()
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

    }

    fun sayHello(view: View) {

        val showCountTextView = view as TextView

        val toast = Toast.makeText(this, showCountTextView.text, Toast.LENGTH_SHORT)

        toast.show()

        val i = Item().apply { name = "randál" }

        ItemDao.createOrUpdate(i)

        items.add(i)

        recyclerView.adapter.notifyDataSetChanged()
    }

    inner class Adapter : RecyclerView.Adapter<Adapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            var view = LayoutInflater.from(this@MainActivity).inflate(R.layout.row_simple, parent, false)
            return ViewHolder(view)
        }

        override fun getItemCount(): Int {
            return items.size
        }

        override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
            holder.textView.text = items[position].name
        }

        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val textView: TextView = view.findViewById(R.id.textView)

        }
    }
}
