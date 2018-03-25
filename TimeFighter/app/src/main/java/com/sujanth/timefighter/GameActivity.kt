package com.sujanth.timefighter

import android.os.Bundle
import android.os.CountDownTimer
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView

class GameActivity : AppCompatActivity() {

    internal lateinit var gameScoreTextView: TextView
    internal lateinit var timeLeftTextView: TextView
    internal lateinit var tapMeButton: Button

    internal var score = 0

    internal var gameStarted = false

    internal lateinit var countdownTimer: CountDownTimer
    internal var initialCountDown: Long = 60000
    internal var countDownInterval: Long = 1000
    internal var timeLeft = 60

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        //Connect views to variables
        gameScoreTextView = findViewById<TextView>(R.id.game_score_text_view)
        timeLeftTextView = findViewById<TextView>(R.id.time_left_text_view)
        tapMeButton = findViewById<Button>(R.id.tab_me_button)

        tapMeButton.setOnClickListener { v -> incrementScore() }

        resetGame()
    }

    private fun incrementScore() {
        //incrementing score logic
        score++

        val newScore = getString(R.string.your_score, Integer.toString(score))
        gameScoreTextView.text = newScore
    }

    private fun resetGame() {
        //resetting game logic
        score = 0

        val initialScore = getString(R.string.your_score, Integer.toString(score))
        gameScoreTextView.text = initialScore

        val initialTimeLeft = getString(R.string.time_left, Integer.toString(60))
        timeLeftTextView.text = initialTimeLeft

        countdownTimer = object :CountDownTimer(initialCountDown, countDownInterval) {
            override fun onTick(millisUntilFinished: Long) {
                timeLeft = millisUntilFinished.toInt() / 1000

                val timeLeftString = getString(R.string.time_left, Integer.toString(timeLeft))
                timeLeftTextView.text = timeLeftString

            }

            override fun onFinish() {

            }
        }

        gameStarted = false

    }

    private fun startGame() {
        //start game logic
    }

    private fun endGame() {
        //end game logic
    }
}
