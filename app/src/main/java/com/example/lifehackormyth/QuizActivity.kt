package com.example.lifehackormyth

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class QuizActivity : AppCompatActivity() {

    // List of flashcard questions
    private val hacks = listOf(
        Hack("Putting your phone in rice fixes water damage.", false,
            "Rice does not remove moisture effectively."),
        Hack("Using keyboard shortcuts boosts productivity.", true,
            "Shortcuts save time and reduce effort."),
        Hack("Charging your phone overnight ruins the battery.", false,
            "Modern phones stop charging automatically.")
    )

    private var currentIndex = 0
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        val txtQuestion = findViewById<TextView>(R.id.txtQuestion)
        val txtFeedback = findViewById<TextView>(R.id.txtFeedback)
        val btnTrue = findViewById<Button>(R.id.btnTrue)
        val btnFalse = findViewById<Button>(R.id.btnFalse)
        val btnNext = findViewById<Button>(R.id.btnNext)

        // Load first question
        loadQuestion(txtQuestion, txtFeedback)

        btnTrue.setOnClickListener {
            checkAnswer(true, txtFeedback)
        }

        btnFalse.setOnClickListener {
            checkAnswer(false, txtFeedback)
        }

        btnNext.setOnClickListener {
            currentIndex++
            if (currentIndex < hacks.size) {
                loadQuestion(txtQuestion, txtFeedback)
            } else {
                // Navigate to ScoreActivity
                val intent = Intent(this, ScoreActivity::class.java)
                intent.putExtra("score", score)
                intent.putExtra("total", hacks.size)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun loadQuestion(questionView: TextView, feedbackView: TextView) {
        questionView.text = hacks[currentIndex].statement
        feedbackView.text = ""
    }

    private fun checkAnswer(userAnswer: Boolean, feedbackView: TextView) {
        val correct = hacks[currentIndex].isTrue == userAnswer
        if (correct) {
            score++
            feedbackView.text = "Correct! ${hacks[currentIndex].explanation}"
        } else {
            feedbackView.text = "Wrong! ${hacks[currentIndex].explanation}"
        }
    }
}