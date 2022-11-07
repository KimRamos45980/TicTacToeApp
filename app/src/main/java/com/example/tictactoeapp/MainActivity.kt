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
        // Holds if game is still ongoing
        var gameFinished = false
        // Holds how many buttons have been clicked
        var numButtonsClicked = 0

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
        // Set to random values not including 0/1 or similar values to not conflict with checkWinner()
        val board: IntArray = intArrayOf(2, 3, 4, 5, 6, 7, 8, 9, 10)

        // New game button reset
        newGame.setOnClickListener {
            playerTurn.text = getString(R.string.TextView, "X")
            player = "X"
            for (button in buttons) {
                button.text = ""
            }
            // reset board element values
            for (i in board.indices) {
                board[i] = (i + 2)
            }
            //Log.i("BoardValues", board.contentToString())
            gameFinished = false
            numButtonsClicked = 0
        }

        // Button click events
        topLeftButton.setOnClickListener {
            if (!gameFinished) {
                numButtonsClicked++
                changeIndexValue(board, 0, player)
                gameFinished = checkWinner(board, player, playerTurn, numButtonsClicked)
                player = changeButtonText(topLeftButton, player, playerTurn, gameFinished)
            }
        }

        topCenterButton.setOnClickListener {
            if (!gameFinished) {
                numButtonsClicked++
                changeIndexValue(board, 1, player)
                gameFinished = checkWinner(board, player, playerTurn, numButtonsClicked)
                player = changeButtonText(topCenterButton, player, playerTurn, gameFinished)
            }
        }

        topRightButton.setOnClickListener {
            if (!gameFinished) {
                numButtonsClicked++
                changeIndexValue(board, 2, player)
                gameFinished = checkWinner(board, player, playerTurn, numButtonsClicked)
                player = changeButtonText(topRightButton, player, playerTurn, gameFinished)
            }
        }

        middleLeftButton.setOnClickListener {
            if (!gameFinished) {
                numButtonsClicked++
                changeIndexValue(board, 3, player)
                gameFinished = checkWinner(board, player, playerTurn, numButtonsClicked)
                player = changeButtonText(middleLeftButton, player, playerTurn, gameFinished)
            }
        }

        middleCenterButton.setOnClickListener {
            if (!gameFinished) {
                numButtonsClicked++
                changeIndexValue(board, 4, player)
                gameFinished = checkWinner(board, player, playerTurn, numButtonsClicked)
                player = changeButtonText(middleCenterButton, player, playerTurn, gameFinished)
            }
        }

        middleRightButton.setOnClickListener {
            if (!gameFinished) {
                numButtonsClicked++
                changeIndexValue(board, 5, player)
                gameFinished = checkWinner(board, player, playerTurn, numButtonsClicked)
                player = changeButtonText(middleRightButton, player, playerTurn, gameFinished)
            }
        }

        bottomLeftButton.setOnClickListener {
            if (!gameFinished) {
                numButtonsClicked++
                changeIndexValue(board, 6, player)
                gameFinished = checkWinner(board, player, playerTurn, numButtonsClicked)
                player = changeButtonText(bottomLeftButton, player, playerTurn, gameFinished)
            }
        }

        bottomCenterButton.setOnClickListener {
            if (!gameFinished) {
                numButtonsClicked++
                changeIndexValue(board, 7, player)
                gameFinished = checkWinner(board, player, playerTurn, numButtonsClicked)
                player = changeButtonText(bottomCenterButton, player, playerTurn, gameFinished)

            }
        }

        bottomRightButton.setOnClickListener {
            if (!gameFinished) {
                numButtonsClicked++
                changeIndexValue(board, 8, player)
                gameFinished = checkWinner(board, player, playerTurn, numButtonsClicked)
                player = changeButtonText(bottomRightButton, player, playerTurn, gameFinished)
            }
        }
    }

    private fun changeButtonText(button: Button, player: String, playerTurn: TextView, gameEnded: Boolean): String {
        var playerChange = player
        if (button.text.equals("")) {
            button.text = player
            // Added to make sure changePlayer() text doesn't override win text
            if (!gameEnded) {
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

    // Changes the values of the board array depending on whose turn it is
    private fun changeIndexValue(board: IntArray, button: Int, player: String) {
        if (board[button] != 0 || board[button] != 1) {
            if (player == "X") {
                board[button] = 0
                //Log.i("BoardValues", board.contentToString())
            } else {
                board[button] = 1
                //Log.i("BoardValues", board.contentToString())
            }
        }
    }

    // Checks all possible win states
    private fun checkWinner(board: IntArray, player: String, playerTurn: TextView, buttonsClicked: Int) : Boolean {
        val won = "Player $player Won!"
        val tie = "It's a tie!"

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
        else if (buttonsClicked == 9) {
            playerTurn.text = tie
            return true
        }

        return false
    }
}
