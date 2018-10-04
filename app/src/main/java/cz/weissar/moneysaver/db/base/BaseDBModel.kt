package cz.weissar.moneysaver.db.base

import com.raizlabs.android.dbflow.sql.language.property.Property
import com.raizlabs.android.dbflow.structure.BaseModel

abstract class BaseDBModel : BaseModel() {

    // pro metody selectById
    abstract var getPrimaryKeyId: Int

    //abstract var getPrimaryKeyProperty: Property<Int>

}