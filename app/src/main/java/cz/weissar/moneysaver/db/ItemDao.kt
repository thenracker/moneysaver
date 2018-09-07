package cz.weissar.moneysaver.db

import com.raizlabs.android.dbflow.sql.language.Select

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
}