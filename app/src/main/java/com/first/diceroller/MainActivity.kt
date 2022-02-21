package com.first.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


//Allows the user to roll a dice and view the result
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.btnRoll)
        rollButton.setOnClickListener{diceRoller()}
        diceRoller()
    }

    class Dice(val num: Int) {

        fun roll(): Int {
            return (1..num).random()
        }
    }

    /* Update the screen with the result */
    private fun diceRoller() {
        val Button = findViewById<Button>(R.id.btnRoll)
        Button.setOnClickListener {
            Toast.makeText(this, "DiceRoll!", Toast.LENGTH_SHORT).show()
            rollDice()
            sumDice()

        }
    }


    private fun rollDice() {
        //Find the ImageView in the layout
        val ivDice = findViewById<ImageView>(R.id.Dice)
        // Find the ImageView for the Dice two
        val ivDiceTwo = findViewById<ImageView>(R.id.diceTwo)
        val dice = Dice(6)
        val diceTwo = Dice(6)
        val diceRoll = dice.roll()
        val diceRollTwo = diceTwo.roll()
        // Determine which ID of drawable to use on the roll
        val drawableResource = when (diceRoll  or  diceRollTwo){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        val drawableResourceTwo = when (diceRollTwo){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        // Update the ImageView with thr correct drawable resource ID
        ivDice.setImageResource(drawableResource)
        ivDiceTwo.setImageResource(drawableResourceTwo)
        // Update the content description
        ivDice.contentDescription = diceRoll.toString()

    }
    private fun sumDice() {

    }
}