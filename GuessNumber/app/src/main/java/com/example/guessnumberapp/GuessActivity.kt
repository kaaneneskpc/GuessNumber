package com.example.guessnumberapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.guessnumberapp.databinding.ActivityGuessBinding
import kotlinx.android.synthetic.main.activity_guess.*
import kotlin.random.Random


class GuessActivity : AppCompatActivity() {
    private var randomNumber = 0
    private var counter = 5


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityGuessBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        randomNumber = Random.nextInt(101)//0 -- 100
        Log.e("randomNumber",randomNumber.toString())

        binding.buttonGuess.setOnClickListener {
            counter=counter - 1
            val guess =  editTextEntry.text.toString().toInt()
            if(guess==randomNumber){
                val intent = Intent(this@GuessActivity,ResultActivity::class.java)
                intent.putExtra("result",true)
                finish()
                startActivity(intent)
            }
            if(guess>randomNumber){
               textViewHelp.text = "Decrease"
               textViewRemainingRight.text = "Remaining Right : $counter"
            }
            if(guess<randomNumber){
                textViewHelp.text = "Increase"
                textViewRemainingRight.text = "Remaining Right : $counter"
            }
            if(counter==0){
                val intent = Intent(this@GuessActivity,ResultActivity::class.java)
                intent.putExtra("result",false)
                finish()
                startActivity(intent)
            }
            editTextEntry.setText("")


        }
    }
}