package cz.weissar.moneysaver.db.model

import com.raizlabs.android.dbflow.annotation.Column
import com.raizlabs.android.dbflow.annotation.PrimaryKey
import com.raizlabs.android.dbflow.annotation.Table
import cz.weissar.moneysaver.db.AppDatabase
import cz.weissar.moneysaver.db.base.BaseDBModel
import cz.weissar.moneysaver.db.converter.CurrencyTypeConverter
import java.util.*

@Table(database = AppDatabase::class)
class ItemEntity() : BaseDBModel() { // nutno ItemEntity() .. aby byl defaultní konsturktor prázdný

    @PrimaryKey(autoincrement = true)
    var id: Int = 0

    @Column
    lateinit var name: String

    @Column
    var amount: Int = 0

    //FIXME achjo nevim jestli pouzit currency z java.util nebo z android.icu.util
    @Column(typeConverter = CurrencyTypeConverter::class)
    lateinit var currency: Currency

    constructor(name: String, amount: kotlin.Int, currency: Currency) : this() {
        this.name = name
        this.amount = amount
        this.currency = currency
    }

    override fun getPrimaryKeyId(): Int {
        return id
    }
}