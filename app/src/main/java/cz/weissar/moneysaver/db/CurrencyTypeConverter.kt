package cz.weissar.moneysaver.db

import com.raizlabs.android.dbflow.converter.TypeConverter
import java.util.*

class CurrencyTypeConverter : TypeConverter<String, Currency>() {

    override fun getDBValue(model: Currency?): String {
       return model.toString()
    }

    override fun getModelValue(data: String?): Currency {
        return Currency.getInstance(data)
    }
}