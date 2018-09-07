package cz.weissar.moneysaver.db

import com.raizlabs.android.dbflow.annotation.Column
import com.raizlabs.android.dbflow.annotation.PrimaryKey
import com.raizlabs.android.dbflow.annotation.Table
import com.raizlabs.android.dbflow.structure.BaseModel

@Table(database = AppDatabase::class)
class Item : BaseModel() {

    @PrimaryKey(autoincrement = true)
    var id: Int = 0

    @Column
    lateinit var name: String

}