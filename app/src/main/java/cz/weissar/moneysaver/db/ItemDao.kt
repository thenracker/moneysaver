package cz.weissar.moneysaver.db

import com.raizlabs.android.dbflow.sql.language.Select
import com.raizlabs.android.dbflow.structure.database.transaction.QueryTransaction

object ItemDao {

    fun createOrUpdate(item: Item){
        item.save()
    }

    fun getAll(): MutableList<Item> {
        return Select()
                .from(Item::class.java)
                .where()
                .orderBy(Item_Table.id, false)
                .queryList()
    }

    /*

    WTF !!! fixme prosím - nechápu jak udělat ekvivalent Javy (dole) v Kotlinu)
    fun getAllAsync() {
        Select()
                .from(Item::class.java)
                .async()
                .queryListResultCallback(QueryTransaction.QueryResultListCallback(function = ()))

        /*
        .async().queryListResultCallback(new QueryTransaction.QueryResultListCallback<RoomInfo>() {
            @Override
            public void onListQueryResult(QueryTransaction transaction, @NonNull List<RoomInfo> tResult) {
                callback.response(tResult);
            }
        }).execute();
         */

    } */
}