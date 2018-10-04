package cz.weissar.moneysaver.ui.base

import com.raizlabs.android.dbflow.sql.queriable.AsyncQuery
import com.raizlabs.android.dbflow.structure.database.transaction.QueryTransaction

interface BaseSingleCallback<T> {

    fun onLoaded(item: T?)

    fun handle(query: AsyncQuery<T>) {
        query.querySingleResultCallback(transaction()).execute()
    }

    private fun transaction(): QueryTransaction.QueryResultSingleCallback<T> {
        return QueryTransaction.QueryResultSingleCallback { _, tResult -> onLoaded(tResult) } // _ = transaction
    }

}