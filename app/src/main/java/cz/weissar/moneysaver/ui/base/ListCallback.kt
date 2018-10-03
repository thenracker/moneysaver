package cz.weissar.moneysaver.ui.base

abstract class ListCallback<T> {

    abstract fun onLoaded() : MutableList<T>


}