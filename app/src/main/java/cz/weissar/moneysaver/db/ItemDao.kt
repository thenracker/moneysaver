package cz.weissar.moneysaver.db

interface ItemDao {

    fun createOrUpdate(itemEntity: ItemEntity)

    fun getAll() : MutableList<ItemEntity>

}