package com.example.mod2demo4

class Sport(val name : String, val type : String, val nbPlayers : Int) {

    private var _isIndoor : Boolean = false

    var isIndoor : Boolean
        get() = _isIndoor

        set(value) {
            _isIndoor = value
        }

    fun displayMatch() : String {
        return "Le match de $name a commencé !"
    }


}
fun main() {
    val hockeyOnIce = Sport("Hockey sur glace", "Collectif", 6)
    println(hockeyOnIce.displayMatch())
    println(hockeyOnIce.isIndoor)
}