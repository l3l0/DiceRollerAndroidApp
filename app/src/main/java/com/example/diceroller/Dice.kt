package com.example.diceroller

class Dice(private val numSides: Int) {
    init {
        if (numSides <= 0) {
            throw DiceNumberOfSidesNeedToBePositive()
        }
    }
    fun roll(): Int {
        return (1..numSides).random()
    }
}
