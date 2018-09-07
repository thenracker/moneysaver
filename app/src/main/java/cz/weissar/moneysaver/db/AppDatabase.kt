package cz.weissar.moneysaver.db

import com.raizlabs.android.dbflow.annotation.Database

@Database(name = AppDatabase.NAME, version = AppDatabase.VERSION, generatedClassSeparator = "_")
object AppDatabase {

    const val NAME: String = "MoneySaverDB" //AppDatabase::class.simpleName.toString()
    const val VERSION: Int = 1

}