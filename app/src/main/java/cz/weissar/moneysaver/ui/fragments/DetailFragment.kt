package cz.weissar.moneysaver.ui.fragments

import android.os.Bundle
import android.view.View
import cz.weissar.moneysaver.R
import cz.weissar.moneysaver.base.ARG_ITEM_ID
import cz.weissar.moneysaver.db.dao.ItemEntityDao
import cz.weissar.moneysaver.ui.base.BaseFragment

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

    override fun getLayoutResId(): Int = R.layout.fragmenet_main //todo vlastní layout na detail

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemId = if (savedInstanceState != null) {
            savedInstanceState.getInt(ARG_ITEM_ID)
        } else {
            arguments!!.getInt(ARG_ITEM_ID)
        }

        var itemEntity = ItemEntityDao.selectById(id)

        // todo naplnit view - chtělo by to rozjet ModelView !!! - ale to už asi před onCreateView při inflatování?
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(ARG_ITEM_ID, itemId)
        super.onSaveInstanceState(outState)
    }
}