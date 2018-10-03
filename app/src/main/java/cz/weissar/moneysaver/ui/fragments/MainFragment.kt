package cz.weissar.moneysaver.ui.fragments

import android.os.Bundle
import android.view.View
import cz.weissar.moneysaver.R
import cz.weissar.moneysaver.ui.base.BaseFragment

class MainFragment : BaseFragment() {

    companion object { //statická metoda
        fun newInstance(): MainFragment {
            return MainFragment()
        }
    }

    override fun getLayoutResId(): Int {
        return R.layout.fragmenet_main
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //TODO naše logika <3
    }
}