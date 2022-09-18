package com.example.diceroller

import org.junit.Test

import org.junit.Assert.*

class DiceUnitTest {
    @Test
    fun generates_number_in_range() {
        val dice = Dice(6)
        val number = dice.roll()

        assertTrue("number is between 1 and 6", number in 1..6)

        val secondDice = Dice(1)
        val secondNumber = secondDice.roll()

        assertEquals(1, secondNumber)
    }

    @Test(expected = DiceNumberOfSidesNeedToBePositive::class)
    fun cannot_be_created_without_sides() {
        Dice(0)
    }

    @Test(expected = DiceNumberOfSidesNeedToBePositive::class)
    fun cannot_be_created_with_negative_sides() {
        Dice(-1)
    }
}