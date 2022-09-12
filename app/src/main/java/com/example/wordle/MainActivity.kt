package com.example.wordle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.content.Context
import android.view.inputmethod.InputMethodManager

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var editText = findViewById<EditText>(R.id.editText)
        val button = findViewById<Button>(R.id.button)
        val textView = findViewById<TextView>(R.id.textView27)
        val textViewForG2 = findViewById<TextView>(R.id.textView11)
        val textViewForG3 = findViewById<TextView>(R.id.textView14)
        val textViewForG4 = findViewById<TextView>(R.id.textView16)
        val checkViewfor1 = findViewById<TextView>(R.id.textView10)
        val checkViewfor2 = findViewById<TextView>(R.id.textView13)
        val checkViewfor3 = findViewById<TextView>(R.id.textView15)
        val checkViewfor4 = findViewById<TextView>(R.id.textView17)
        val Word = findViewById<TextView>(R.id.textView28)

        var counter: Int = 0
        Word.visibility = View.GONE
        Word.text = wordToGuess

        button.setOnClickListener {
            it.hideKeyboard()
            counter = counter + 1
            if (counter == 1) {
                var guess1 = editText.text.toString()
                textView.text = guess1
                editText.text.clear()
                var checkFunction = checkGuess(guess1)
                checkViewfor1.text = checkFunction



            }else if (counter == 2) {

                var guess2 = editText.text.toString()
                textViewForG2.text = guess2
                editText.text.clear()
                var checkFunction = checkGuess(guess2)
                checkViewfor2.text = checkFunction


            }else if(counter == 3){

                var guess3 = editText.text.toString()
                textViewForG3.text = guess3
                editText.text.clear()
                var checkFunction = checkGuess(guess3)
                checkViewfor3.text = checkFunction


            }else if(counter == 4){

                var guess4 = editText.text.toString()
                textViewForG4.text = guess4
                editText.text.clear()
                var checkFunction = checkGuess(guess4)
                checkViewfor4.text = checkFunction
                Word.visibility = View.VISIBLE
            }
        }
    }
    fun View.hideKeyboard() {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken, 0)
    }





   var wordToGuess = FourLetterWordList.getRandomFourLetterWord()

    private fun checkGuess(guess: String) : String {
        var result = ""
        var Guess = guess.lowercase()
        var Word = wordToGuess.lowercase()

        for (i in 0..3) {
            if (Guess[i] == Word[i]) {
                result += "O"
            }
            else if (guess[i] in Word) {
                result += "+"
            }
            else {
                result += "X"
            }
        }
        return result
    }
}


