package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        logging()
        diceRoll(R.id.diceView)
        val rollButton: Button = findViewById(R.id.rollButton)
        rollButton.setOnClickListener {
            Toast.makeText(this, "Dice rolled!", Toast.LENGTH_SHORT).show()

            diceRoll(R.id.diceView)
        }
    }

    private fun logging() {
        Log.v(TAG, "Hello world")
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun diceRoll(id: Int) {
        val diceRoll = Dice(6).roll()
        val drawableId = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        val diceImage = findViewById<ImageView>(id)
        diceImage.setImageResource(drawableId)
        diceImage.contentDescription = diceRoll.toString()
    }
}