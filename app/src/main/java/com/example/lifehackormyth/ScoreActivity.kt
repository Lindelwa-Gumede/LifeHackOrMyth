package com.example.lifehackormyth

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ScoreActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        val score = intent.getIntExtra("score", 0)
        val total = intent.getIntExtra("total", 0)

        val txtScore = findViewById<TextView>(R.id.txtScore)
        val txtMessage = findViewById<TextView>(R.id.txtMessage)

        txtScore.text = "You scored $score out of $total"

        txtMessage.text = if (score > total / 2) {
            "Master Hacker!"
        } else {
            "Stay Safe Online!"
        }
    }
}
