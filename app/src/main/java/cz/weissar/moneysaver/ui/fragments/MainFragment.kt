package cz.weissar.moneysaver.ui.fragments

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import cz.weissar.moneysaver.R
import cz.weissar.moneysaver.db.dao.ItemEntityDao
import cz.weissar.moneysaver.db.model.ItemEntity
import cz.weissar.moneysaver.ui.base.BaseFragment
import cz.weissar.moneysaver.ui.base.BaseListCallback
import kotlinx.android.synthetic.main.fragmenet_main.*
import java.util.*

class MainFragment : BaseFragment() {

    private lateinit var itemEntities: MutableList<ItemEntity>

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
        itemEntities = ItemEntityDao.getAll()
        val adapter = Adapter()
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

        saveButton.setOnClickListener {
            if (!amountEditText.text.isEmpty()) {
                val item = ItemEntity(noteEditText.text.toString(), amountEditText.text.toString().toInt(), Currency.getInstance("CZK"))
                ItemEntityDao.createOrUpdate(item)
                itemEntities.add(item)
                recyclerView.adapter.notifyItemInserted(itemEntities.size - 1)
            }
        }


        ItemEntityDao.getAllAsync(object : BaseListCallback<ItemEntity> {
            override fun onLoaded(list: MutableList<ItemEntity>) {
                // <3 a není třeba řešit transaction
            }
        }
        )

    }

    inner class Adapter : RecyclerView.Adapter<Adapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            var view = LayoutInflater.from(this@MainFragment.context).inflate(R.layout.row_simple, parent, false)
            return ViewHolder(view)
        }

        override fun getItemCount(): Int {
            return itemEntities.size
        }

        override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
            holder.textView.text = itemEntities[position].name
        }

        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener, View.OnLongClickListener {

            val textView: TextView = view.findViewById(R.id.textView)

            init {
                view.setOnClickListener(this)
                view.setOnLongClickListener(this)
            }

            override fun onClick(p0: View?) {
                Toast.makeText(context, itemEntities[layoutPosition].amount.toString(), Toast.LENGTH_SHORT).show()
            }

            override fun onLongClick(p0: View?): Boolean {
                ItemEntityDao.delete(itemEntities.removeAt(layoutPosition))
                notifyDataSetChanged()
                return true
            }
        }
    }

}