package com.example.mod2demo4

open class Sport(val name : String, val type : String, val nbPlayers : Int) {

    private var _isIndoor : Boolean = false

    var isIndoor : Boolean
        get() = _isIndoor

        set(value) {
            _isIndoor = value
        }

    open fun displayMatch() : String {
        return "Le match de $name a commencé !"
    }


}

class SportCo(name : String, nbPlayers : Int) : Sport(name, type = "Collectif", nbPlayers) {

    override fun displayMatch(): String {
        return super.displayMatch() + " et est $type"
    }
}


fun main() {
    val hockeyOnIce = Sport("Hockey sur glace", "Collectif", 6)
    println(hockeyOnIce.displayMatch())
    println(hockeyOnIce.isIndoor)

    val basket = SportCo("Basket", 5)
    println(basket.displayMatch())
}