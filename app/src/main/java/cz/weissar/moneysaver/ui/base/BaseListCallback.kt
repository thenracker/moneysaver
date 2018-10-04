package cz.weissar.moneysaver.ui.base

abstract class BaseListCallback<T> {

    abstract fun onLoaded() : MutableList<T>


}