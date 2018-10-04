package cz.weissar.moneysaver.db.model

import java.io.Serializable
import java.util.*

class Item : Serializable {

    var id: Int = 0
    lateinit var name: String
    var amount: Int = 0
    //expertiment misto Stringu
    lateinit var currency: Currency

    constructor(id: Int, name: String, amount: Int, currency: Currency) {
        this.id = id
        this.name = name
        this.amount = amount
        this.currency = currency
    }

    constructor(name: String, amount: Int, currency: Currency) {
        this.name = name
        this.amount = amount
        this.currency = currency
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Item

        if (id != other.id) return false
        if (name != other.name) return false
        if (amount != other.amount) return false
        if (currency != other.currency) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + name.hashCode()
        result = 31 * result + amount
        result = 31 * result + currency.hashCode()
        return result
    }

    override fun toString(): String {
        return "Item(id=$id, name='$name', amount=$amount, currency=$currency)"
    }


}