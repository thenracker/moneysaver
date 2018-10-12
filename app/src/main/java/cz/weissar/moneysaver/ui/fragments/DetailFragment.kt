package cz.weissar.moneysaver.ui.fragments

import android.os.Bundle
import android.view.View
import cz.weissar.moneysaver.R
import cz.weissar.moneysaver.base.ARG_ITEM_ID
import cz.weissar.moneysaver.db.dao.ItemEntityDao
import cz.weissar.moneysaver.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment : BaseFragment() {

    companion object {
        fun newInstance(id: Int): DetailFragment {
            var detailFragment = DetailFragment()
            var bundle = Bundle()
            bundle.putInt(ARG_ITEM_ID, id)
            detailFragment.arguments = bundle
            return detailFragment
        }
    }

    private var itemId : Int = 0

    override fun getLayoutResId(): Int = R.layout.fragment_detail

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemId = savedInstanceState?.getInt(ARG_ITEM_ID) ?: arguments!!.getInt(ARG_ITEM_ID)

        var itemEntity = ItemEntityDao.selectById(itemId)

        itemNameTextView.text = itemEntity?.name
        itemCountTextView.text = itemEntity?.amount.toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(ARG_ITEM_ID, itemId)
        super.onSaveInstanceState(outState)
    }
}