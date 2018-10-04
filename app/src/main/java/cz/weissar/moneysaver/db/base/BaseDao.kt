package cz.weissar.moneysaver.db.base

import com.raizlabs.android.dbflow.sql.language.Select
import com.raizlabs.android.dbflow.sql.language.property.Property
import cz.weissar.moneysaver.ui.base.BaseListCallback
import cz.weissar.moneysaver.ui.base.BaseSingleCallback

abstract class BaseDao<T : BaseDBModel> {

    // know how - takové metody s infline reified nelze vyolat z javy

    fun createOrUpdate(item: T) =
            item.save()

    fun createOrUpdateAsync(item: T) =
            item.async().save()

    fun delete(item: T) =
            item.delete()

    fun deleteAsync(item: T) =
            item.async().delete()

    inline fun <reified T : BaseDBModel> selectById(id: Int, property: Property<Int>): T? =
            Select().from(T::class.java).where(property.eq(id)).querySingle()

    inline fun <reified T : BaseDBModel> selectByIdAsync(id: Int, property: Property<Int>, callback: BaseSingleCallback<T>) =
            callback.handle(Select().from(T::class.java).where(property.eq(id)).async())

    inline fun <reified T : BaseDBModel> selectAll(): MutableList<T> =
            Select().from(T::class.java).queryList()

    inline fun <reified T : BaseDBModel> selectAllAsync(callback: BaseListCallback<T>) =
            callback.handle(Select().from(T::class.java).async())


    // TODO - selectCountOf


    /*
    KNOW HOW DO PŘÍŠTĚ

    //sexy verze
    fun selectAllAsync(callback : BaseListCallback<ItemEntity>) {

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