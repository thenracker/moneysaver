package cz.weissar.moneysaver.ui.base

import com.raizlabs.android.dbflow.sql.queriable.AsyncQuery
import com.raizlabs.android.dbflow.structure.database.transaction.QueryTransaction

interface BaseListCallback<T> {

    fun onLoaded(list: MutableList<T>)

    fun handle(query: AsyncQuery<T>) {
        query.queryListResultCallback(transaction()).execute()
    }

    private fun transaction(): QueryTransaction.QueryResultListCallback<T> = QueryTransaction.QueryResultListCallback { _, tResult -> onLoaded(tResult) } // _ = transaction

}