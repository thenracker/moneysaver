package cz.weissar.moneysaver.koin

import org.koin.dsl.module.module

interface HelloRepo { // co jsem pochopil, tak interface není úplně třeba ..
    // ledaže bychom použil nějaký baseRepository jakoby.. to by dávalo smysl?

    fun giveHello(): String


    // https://insert-koin.io/docs/1.0/getting-started/kotlin/
    // Reálný využití KOIN s data class
}

class HelloRepoImpl : HelloRepo {

    override fun giveHello() = "Hello Koin"

}

// presenters
class MainActivityPresenter(private val repo: HelloRepo) {

    fun sayHello() = "${repo.giveHello()} z presenteru ${this.javaClass.simpleName}"
}


// modules
val appModule = module { //fixme - mělo by se zde jednat o nějaký mainModule když je v main aktivitě

    single<HelloRepo> { HelloRepoImpl() }

    factory { MainActivityPresenter(get()) }

}