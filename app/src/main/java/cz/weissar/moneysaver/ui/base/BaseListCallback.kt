package cz.weissar.moneysaver.ui.base

import com.raizlabs.android.dbflow.structure.database.transaction.QueryTransaction

interface BaseListCallback<T> {

    fun onLoaded(list: MutableList<T>)

    fun transaction(): QueryTransaction.QueryResultListCallback<T> {
        return QueryTransaction.QueryResultListCallback { transaction, tResult -> onLoaded(tResult) }
    }

}