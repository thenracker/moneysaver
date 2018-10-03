package cz.weissar.moneysaver.ui.fragments

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import cz.weissar.moneysaver.R
import cz.weissar.moneysaver.db.Item
import cz.weissar.moneysaver.db.ItemDao
import cz.weissar.moneysaver.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragmenet_main.*

class MainFragment : BaseFragment() {

    private lateinit var items: MutableList<Item>

    companion object { //static methods

        fun newInstance(): MainFragment {
            return MainFragment()
        }
    }

    override fun getLayoutResId(): Int {
        return R.layout.fragmenet_main
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initItems()
    }

    private fun initItems() {

        items = ItemDao.getAll()
        val adapter = Adapter()
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

    }

    inner class Adapter : RecyclerView.Adapter<Adapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            var view = LayoutInflater.from(this@MainFragment.context).inflate(R.layout.row_simple, parent, false)
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

}