package cz.weissar.moneysaver.db.base

import com.raizlabs.android.dbflow.sql.language.Select

abstract class BaseDao<T : BaseDBModel> {

    fun createOrUpdate(item: T) {
        item.save()
    }

    fun delete(item : T){
        item.delete()
    }

    /* .. no tak můj nápad s generickým BaseDao v Kotlinu úplně nejede kurva! .. tak aspoň ten createOrUpdate tu je
    inline fun <reified T : BaseDBModel> getById(id : kotlin.Int): T {
        Select()
                .from(T::class.java)
                .where()
    }*/

    // TODO napsat obyč -> viz metoda níže - on když chceme T::class.java, tak potřebuje to reified a to zase nejde dát nahoru do třídy
    fun getAllFuckedUp(): MutableList<T> {
        return null!!
    }

    inline fun <reified T : BaseDBModel> getAllReified(): MutableList<T> {
        return Select().from(T::class.java).queryList()
    }

}