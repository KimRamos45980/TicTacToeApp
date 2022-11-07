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
        var gameEnd = false

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

        // Array of ints to indicate the board, TopLeft = index 0 -> TopRight = index 2, etc.
        // Set to random values not including 0/1 or similar values done to not conflict with checkWinner()
        val board: IntArray = intArrayOf(2, 3, 4, 5, 6, 7, 8, 9, 10)

        // New game button reset
        newGame.setOnClickListener {
            playerTurn.text = getString(R.string.TextView, "X")
            player = "X"
            for (button in buttons) {
                button.text = ""
            }
            for (i in board.indices) {
                board[i] = (i + 2)
            }
            Log.i("BoardValues", board.contentToString())
            gameEnd = false
        }

        // Button click events
        topLeftButton.setOnClickListener {
            if (!gameEnd) {
                changeIndexValue(board, 0, player)
                gameEnd = checkWinner(board, player, playerTurn)
                player = changeButtonText(topLeftButton, player, playerTurn, gameEnd)
            }
        }

        topCenterButton.setOnClickListener {
            if (!gameEnd) {
                changeIndexValue(board, 1, player)
                gameEnd = checkWinner(board, player, playerTurn)
                player = changeButtonText(topCenterButton, player, playerTurn, gameEnd)
            }
        }

        topRightButton.setOnClickListener {
            if (!gameEnd) {
                changeIndexValue(board, 2, player)
                gameEnd = checkWinner(board, player, playerTurn)
                player = changeButtonText(topRightButton, player, playerTurn, gameEnd)
            }
        }

        middleLeftButton.setOnClickListener {
            if (!gameEnd) {
                changeIndexValue(board, 3, player)
                gameEnd = checkWinner(board, player, playerTurn)
                player = changeButtonText(middleLeftButton, player, playerTurn, gameEnd)
            }
        }

        middleCenterButton.setOnClickListener {
            if (!gameEnd) {
                changeIndexValue(board, 4, player)
                gameEnd = checkWinner(board, player, playerTurn)
                player = changeButtonText(middleCenterButton, player, playerTurn, gameEnd)
            }
        }

        middleRightButton.setOnClickListener {
            if (!gameEnd) {
                changeIndexValue(board, 5, player)
                gameEnd = checkWinner(board, player, playerTurn)
                player = changeButtonText(middleRightButton, player, playerTurn, gameEnd)
            }
        }

        bottomLeftButton.setOnClickListener {
            if (!gameEnd) {
                changeIndexValue(board, 6, player)
                gameEnd = checkWinner(board, player, playerTurn)
                player = changeButtonText(bottomLeftButton, player, playerTurn, gameEnd)
            }
        }

        bottomCenterButton.setOnClickListener {
            if (!gameEnd) {
                changeIndexValue(board, 7, player)
                gameEnd = checkWinner(board, player, playerTurn)
                player = changeButtonText(bottomCenterButton, player, playerTurn, gameEnd)
            }
        }

        bottomRightButton.setOnClickListener {
            if (!gameEnd) {
                changeIndexValue(board, 8, player)
                gameEnd = checkWinner(board, player, playerTurn)
                player = changeButtonText(bottomRightButton, player, playerTurn, gameEnd)
            }
        }
    }

    private fun changeButtonText(button: Button, player: String, playerTurn: TextView, gameEnd: Boolean): String {
        var playerChange = player
        if (button.text.equals("")) {
            button.text = player
            if (!gameEnd) {
                playerChange = changePlayer(player)
                playerTurn.text = getString(R.string.TextView, playerChange)
            }
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
        if (board[button] != 0 || board[button] != 1) {
            if (player == "X") {
                board[button] = 0
                Log.i("BoardValues", board.contentToString())
            } else {
                board[button] = 1
                Log.i("BoardValues", board.contentToString())
            }
        }
    }

    private fun checkWinner(board: IntArray, player: String, playerTurn: TextView) : Boolean {
        val won = "Player $player Won!"
        if (board[0] == board[1] && board[1] == board[2]) {
            playerTurn.text = won
            return true
        }
        else if (board[3] == board[4] && board[4] == board[5]) {
            playerTurn.text = won
            return true
        }
        else if (board[6] == board[7] && board[7] == board[8]) {
            playerTurn.text = won
            return true
        }
        else if (board[0] == board[3] && board[3] == board[6]) {
            playerTurn.text = won
            return true
        }
        else if (board[1] == board[4] && board[4] == board[7]) {
            playerTurn.text = won
            return true
        }
        else if (board[2] == board[5] && board[5] == board[8]) {
            playerTurn.text = won
            return true
        }
        else if (board[0] == board[4] && board[4] == board[8]) {
            playerTurn.text = won
            return true
        }
        else if (board[2] == board[4] && board[4] == board[6]) {
            playerTurn.text = won
            return true
        }
        return false
    }
}
