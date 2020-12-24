package com.example.guessnumberapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.guessnumberapp.databinding.ActivityResultBinding
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityResultBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        val result = intent.getBooleanExtra("result",false)

        if(result == true){
            textViewResult.text="WIN"
            imageViewResult.setImageResource(R.drawable.smile)
        }
        else{
            textViewResult.text="LOSE"
            imageViewResult.setImageResource(R.drawable.unhappy)
        }

        binding.buttonPlayAgain.setOnClickListener {
            val intent = Intent(this@ResultActivity,MainActivity::class.java)
            finish()
            startActivity(intent)
        }
    }
}