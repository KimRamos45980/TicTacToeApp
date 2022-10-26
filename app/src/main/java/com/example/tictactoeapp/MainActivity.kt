package com.example.tictactoeapp
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Grab the player turn text box view
        val playerTurn = findViewById<TextView>(R.id.textView)
        // Set StartupText to display a player letter and not just placeholder text
        playerTurn.text = getString(R.string.TextView, "X")
        // Holds which player letter's turn it is
        var player = "X"

        // All buttons on screen assigned to a variable
        val topLeftButton = findViewById<Button>(R.id.top_left_button)
        val topCenterButton = findViewById<Button>(R.id.top_center_button)
        val topRightButton = findViewById<Button>(R.id.top_right_button)
        val middleLeftButton = findViewById<Button>(R.id.middle_left_button)
        val middleCenterButton = findViewById<Button>(R.id.middle_center_button)
        val middleRightButton = findViewById<Button>(R.id.middle_right_button)
        val bottomLeftButton = findViewById<Button>(R.id.bottom_left_button)
        val bottomCenterButton = findViewById<Button>(R.id.bottom_center_button)
        val bottomRightButton = findViewById<Button>(R.id.bottom_right_button)
        val newGame = findViewById<Button>(R.id.new_game)

        // Array of game buttons to make resetting easier
        val buttons = arrayOf(
            topLeftButton,
            topCenterButton,
            topRightButton,
            middleLeftButton,
            middleCenterButton,
            middleRightButton,
            bottomLeftButton,
            bottomCenterButton,
            bottomRightButton
        )

        // New game button reset
        newGame.setOnClickListener {
            playerTurn.text = getString(R.string.TextView, "X")
            player = "X"
            for (button in buttons) {
                button.text = ""
            }
        }

        // Button click events
        topLeftButton.setOnClickListener {
            changeButtonText(topLeftButton, player, playerTurn)
        }

        topCenterButton.setOnClickListener {
            changeButtonText(topCenterButton, player, playerTurn)
        }

        topRightButton.setOnClickListener {
            changeButtonText(topRightButton, player, playerTurn)
        }

        middleLeftButton.setOnClickListener {
            changeButtonText(middleLeftButton, player, playerTurn)
        }

        middleCenterButton.setOnClickListener {
            changeButtonText(middleCenterButton, player, playerTurn)
        }

        middleRightButton.setOnClickListener {
            changeButtonText(middleRightButton, player, playerTurn)
        }

        bottomLeftButton.setOnClickListener {
            changeButtonText(bottomLeftButton, player, playerTurn)
        }

        bottomCenterButton.setOnClickListener {
            changeButtonText(bottomCenterButton, player, playerTurn)
        }

        bottomRightButton.setOnClickListener {
            changeButtonText(bottomRightButton, player, playerTurn)
        }

    }

    private fun changeButtonText(button: Button, player: String, playerTurn: TextView) {
        if (button.text.equals("")) {
            button.text = player
            changePlayer(player)
            playerTurn.text = getString(R.string.TextView, player)
        }
    }

    private fun changePlayer(turn: String): String {
        var changeTurn = turn
        changeTurn = if (changeTurn == "X") {
            "O"
        } else {
            "X"
        }
        return changeTurn
    }
}
