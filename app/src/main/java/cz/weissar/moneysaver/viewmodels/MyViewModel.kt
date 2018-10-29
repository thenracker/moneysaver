package cz.weissar.moneysaver.viewmodels

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import cz.weissar.moneysaver.db.dao.ItemEntityDao
import cz.weissar.moneysaver.db.model.ItemEntity
import cz.weissar.moneysaver.ui.base.BaseListCallback

class MyViewModel : ViewModel() {

    private lateinit var items: MutableLiveData<List<ItemEntity>> //MutableLiveData

    fun getItems(): LiveData<List<ItemEntity>> {
        if (!::items.isInitialized) {
            items = MutableLiveData()
            loadItems()
        }
        return items
    }

    private fun loadItems() {
        // asynchronní načítání <3
        ItemEntityDao.selectAllAsync(object : BaseListCallback<ItemEntity> {
            override fun onLoaded(list: MutableList<ItemEntity>) {
                //items = list
                // ojojo.. asi přes LiveData ;) .. nebo změnit z LiveData<XY> na List
            }
        })
    }
}