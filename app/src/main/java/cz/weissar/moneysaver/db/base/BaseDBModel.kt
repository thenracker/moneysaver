package cz.weissar.moneysaver.db.base

import com.raizlabs.android.dbflow.structure.BaseModel

abstract class BaseDBModel : BaseModel() {

    abstract fun getPrimaryKeyId() : kotlin.Int
}