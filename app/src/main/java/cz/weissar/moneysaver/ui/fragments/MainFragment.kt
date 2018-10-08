package cz.weissar.moneysaver.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import cz.weissar.moneysaver.R
import cz.weissar.moneysaver.base.ARG_ITEM_ID
import cz.weissar.moneysaver.db.dao.ItemEntityDao
import cz.weissar.moneysaver.db.model.ItemEntity
import cz.weissar.moneysaver.ui.activities.DetailActivity
import cz.weissar.moneysaver.ui.base.BaseFragment
import cz.weissar.moneysaver.ui.base.BaseListCallback
import kotlinx.android.synthetic.main.fragmenet_main.*
import java.util.*

class MainFragment : BaseFragment() {

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

        // asynchronní načítání <3
        ItemEntityDao.selectAllAsync(object : BaseListCallback<ItemEntity> {
            override fun onLoaded(list: MutableList<ItemEntity>) {
                initAdapter(list)
            }
        })

    }

    private fun initAdapter(list: MutableList<ItemEntity>) {

        val adapter = Adapter(list)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

        saveButton.setOnClickListener {
            if (!amountEditText.text.isEmpty()) {
                val item = ItemEntity(noteEditText.text.toString(), amountEditText.text.toString().toInt(), Currency.getInstance("CZK"))
                ItemEntityDao.createOrUpdateAsync(item)
                adapter.itemEntities.add(item)
                recyclerView.adapter.notifyItemInserted(adapter.itemEntities.size - 1)
            }
        }
    }

    inner class Adapter(var itemEntities: MutableList<ItemEntity>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

        //var itemEntities: MutableList<ItemEntity> = itemEntities //není třeba, když jsme do konstruktoru dali var

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(LayoutInflater.from(this@MainFragment.context).inflate(R.layout.row_simple, parent, false))

        override fun getItemCount(): Int = itemEntities.size

        override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
            holder.textView.text = itemEntities[position].name
        }

        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener, View.OnLongClickListener {

            val textView: TextView = view.findViewById(R.id.textView)

            init {
                view.setOnClickListener(this)
                view.setOnLongClickListener(this)
            }

            override fun onClick(view: View?) {
                var intent = Intent(context, DetailActivity::class.java)
                intent.putExtra(ARG_ITEM_ID, itemEntities[layoutPosition].id)
                startActivity(intent)
                //Toast.makeText(context, itemEntities[layoutPosition].amount.toString(), Toast.LENGTH_SHORT).show()
            }

            override fun onLongClick(view: View?): Boolean {
                ItemEntityDao.deleteAsync(itemEntities.removeAt(layoutPosition))
                notifyItemRemoved(layoutPosition)
                return true
            }
        }
    }

}