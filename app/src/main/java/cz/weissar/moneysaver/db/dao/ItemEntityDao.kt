package cz.weissar.moneysaver.db.dao

import com.raizlabs.android.dbflow.sql.language.Select
import com.raizlabs.android.dbflow.structure.database.transaction.QueryTransaction
import cz.weissar.moneysaver.db.base.BaseDao
import cz.weissar.moneysaver.db.model.ItemEntity
import cz.weissar.moneysaver.db.model.ItemEntity_Table

object ItemEntityDao : BaseDao<ItemEntity>() {

    // není třeba už create or update :)

    fun getAll(): MutableList<ItemEntity> {
        return Select()
                .from(ItemEntity::class.java)
                .where()
                .orderBy(ItemEntity_Table.id, false)
                .queryList()
    }

    //sexy verze
    fun getAllAsync() {
        Select()
                .from(ItemEntity::class.java)
                .async()
                .queryListResultCallback { transaction, tResult ->
                    //callback.response(tResult);
                }
    }

    //upovidana verze
    fun getAllAsyncVerbose() {
        Select()
                .from(ItemEntity::class.java)
                .async()
                .queryListResultCallback(object : QueryTransaction.QueryResultListCallback<ItemEntity> {

                    override fun onListQueryResult(transaction: QueryTransaction<*>?, tResult: MutableList<ItemEntity>) {
                        //callback.response(tResult);
                    }
                })
    }


        /* JAVA
        .async().queryListResultCallback(new QueryTransaction.QueryResultListCallback<RoomInfo>() {
            @Override
            public void onListQueryResult(QueryTransaction transaction, @NonNull List<RoomInfo> tResult) {
                callback.response(tResult);
            }
        }).execute();
         */

}