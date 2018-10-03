package cz.weissar.moneysaver.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import cz.weissar.moneysaver.R
import cz.weissar.moneysaver.ui.fragments.MainFragment

class MainActivity : AppCompatActivity() {

    //private lateinit var recycler: RecyclerView
    //private lateinit var items: MutableList<Item>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(R.id.container, MainFragment.newInstance()).commitAllowingStateLoss()
        }

        //recycler = recyclerView
        //helloTextView.text = "Klikni na mě"

        //initItems()
    }

    /*
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
    */

    /*
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

        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener, View.OnLongClickListener {

            val textView: TextView = view.findViewById(R.id.textView)

            init {
                view.setOnLongClickListener(this)
            }

            override fun onClick(p0: View?) {
            }

            override fun onLongClick(p0: View?): Boolean {
                items.removeAt(layoutPosition).delete()
                notifyDataSetChanged()
                return true
            }
        }
    }
    */
}
