package cz.weissar.moneysaver.db.base

import com.raizlabs.android.dbflow.sql.language.Select
import com.raizlabs.android.dbflow.sql.language.property.Property
import cz.weissar.moneysaver.ui.base.BaseListCallback

abstract class BaseDao<T : BaseDBModel> {

    fun createOrUpdate(item: T) {
        item.save()
    }

    fun delete(item: T) {
        item.delete()
    }

    inline fun <reified T : BaseDBModel> selectById(id: Int, property: Property<Int>): T? {
        return Select().from(T::class.java).where(property.eq(id)).querySingle()
    }

    inline fun <reified T : BaseDBModel> getAll(): MutableList<T> {
        return Select().from(T::class.java).queryList()
    }

    inline fun <reified T : BaseDBModel> getAllAsync(callback: BaseListCallback<T>) {
        Select()
                .from(T::class.java)
                .async()
                .queryListResultCallback(callback.transaction())
                .execute()
    }




    /*
    KNOW HOW DO PŘÍŠTĚ

    //sexy verze
    fun getAllAsync(callback : BaseListCallback<ItemEntity>) {

        *//*
        Select()
                .from(ItemEntity::class.java)
                .async()
                .queryListResultCallback { transaction, tResult ->
                    //callback.response(tResult);
                }
         *//*

        Select()
                .from(ItemEntity::class.java)
                .async()
                .queryListResultCallback(callback.transaction())
                .execute()
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

     */
}