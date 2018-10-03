package cz.weissar.moneysaver.db

import com.raizlabs.android.dbflow.sql.language.Select
import com.raizlabs.android.dbflow.structure.database.transaction.QueryTransaction

object ItemDaoImpl : ItemDao {

    override fun createOrUpdate(itemEntity: ItemEntity){
        itemEntity.save()
    }

    override fun getAll(): MutableList<ItemEntity> {
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