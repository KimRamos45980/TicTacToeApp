package com.example.tictactoeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttons = arrayOf(
            findViewById(R.id.top_left_button),
            findViewById(R.id.top_center_button),
            findViewById(R.id.top_right_button),
            findViewById(R.id.middle_left_button),
            findViewById(R.id.middle_center_button),
            findViewById(R.id.middle_right_button),
            findViewById(R.id.bottom_left_button),
            findViewById(R.id.bottom_center_button),
            findViewById<Button>(R.id.bottom_right_button)
        )

        val newGame = findViewById<Button>(R.id.new_game)
        newGame.setOnClickListener {
            for (button in buttons) {
                button.text = ""
            }
        }
    }
}