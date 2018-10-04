package cz.weissar.moneysaver.db.dao

import cz.weissar.moneysaver.db.base.BaseDao
import cz.weissar.moneysaver.db.model.ItemEntity
import cz.weissar.moneysaver.db.model.ItemEntity_Table

object ItemEntityDao : BaseDao<ItemEntity>() {

    // není třeba už create or update, ani delete, ani getAll ani whatever :)

    fun selectById(itemId: Int): ItemEntity? {
        return selectById(itemId, ItemEntity_Table.id)
    }

    fun getAll2() : MutableList<ItemEntity> {
        return getAll()
    }


}