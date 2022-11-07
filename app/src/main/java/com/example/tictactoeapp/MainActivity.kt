package com.example.tictactoeapp
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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

        // Array of ints to indicate the board, TopLeft = index 0 -> TopRight = index 3, etc.
        val board: IntArray = intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0)

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
            changeIndexValue(board, 0, player)
            player = changeButtonText(topLeftButton, player, playerTurn)
        }

        topCenterButton.setOnClickListener {
            changeIndexValue(board, 1, player)
            player = changeButtonText(topCenterButton, player, playerTurn)
        }

        topRightButton.setOnClickListener {
            changeIndexValue(board, 2, player)
            player = changeButtonText(topRightButton, player, playerTurn)
        }

        middleLeftButton.setOnClickListener {
            changeIndexValue(board, 3, player)
            player = changeButtonText(middleLeftButton, player, playerTurn)
        }

        middleCenterButton.setOnClickListener {
            changeIndexValue(board, 4, player)
            player = changeButtonText(middleCenterButton, player, playerTurn)
        }

        middleRightButton.setOnClickListener {
            changeIndexValue(board, 5, player)
            player = changeButtonText(middleRightButton, player, playerTurn)
        }

        bottomLeftButton.setOnClickListener {
            changeIndexValue(board, 6, player)
            player = changeButtonText(bottomLeftButton, player, playerTurn)
        }

        bottomCenterButton.setOnClickListener {
            changeIndexValue(board, 7, player)
            player = changeButtonText(bottomCenterButton, player, playerTurn)
        }

        bottomRightButton.setOnClickListener {
            changeIndexValue(board, 8, player)
            player = changeButtonText(bottomRightButton, player, playerTurn)
        }
    }

    private fun changeButtonText(button: Button, player: String, playerTurn: TextView): String {
        var playerChange = player
        if (button.text.equals("")) {
            button.text = player
            playerChange = changePlayer(player)
            playerTurn.text = getString(R.string.TextView, playerChange)
        }
        return playerChange
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

    private fun changeIndexValue(board: IntArray, button: Int, player: String) {
        if (player == "X") {
            board[button] = 1
            Log.i("Check", board.contentToString())
        }
        else {
            board[button] = 2
            Log.i("Check", board.contentToString())
        }
    }
}
