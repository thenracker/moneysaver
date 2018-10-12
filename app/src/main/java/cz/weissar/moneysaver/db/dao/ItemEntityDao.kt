package cz.weissar.moneysaver.db.dao

import cz.weissar.moneysaver.db.base.BaseDao
import cz.weissar.moneysaver.db.model.ItemEntity
import cz.weissar.moneysaver.db.model.ItemEntity_Table

object ItemEntityDao : BaseDao<ItemEntity>() {

    // není třeba už create or update, ani delete, ani selectAll ani whatever :)

    // todo použít v detailu při otevírání položky a obdobně by se plnil i async
    fun selectById(itemId: Int): ItemEntity? {
        //     Select().from(ItemEntity::class.java).where(ItemEntity_Table.id.eq(1)).querySingle()
        return selectById(itemId, ItemEntity_Table.id)
    }

}