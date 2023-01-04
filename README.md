# Tic Tac Toe (Java)
This is a simple Tic Tac Toe game implemented in 2 versions in Java. 
One which is played in the terminal/console and the other 
has a Graphical User Interface (GUI) which was implemented using the Swing GUI library. 

### GUI version
The game has a 3x3 grid for the players to place their respective symbols (either X or O). The player with three of their symbols in a row (horizontal, vertical, or diagonal) wins the game. If all of the spaces on the grid are filled and no player has won, the game is a draw.

The game has a "New Game" button that allows the players to start a new game after the current game has ended.

### GUI Configuration
The Tic Tac Toe game is implemented in the TicTacToe class, which extends the JFrame class and implements the ActionListener interface. The game board is made up of a 2D array of JButton objects and there is a separate JButton for starting a new game. The currentPlayer class variable keeps track of which player's turn it is.

The game board and "New Game" button are set up in the constructor for the TicTacToe class. The game board is created using a nested loop that creates a new JButton object for each space on the grid and sets its size, font, and action listener. The "New Game" button is also created and its action listener is set.

### GUI Gameplay
When a player clicks on a space on the game board, the symbol for their current turn (either X or O) is placed on the button and the currentPlayer variable is updated. The game checks for a win or a draw after each turn. If either of these conditions is met, a message dialog is displayed to announce the winner or that the game is a draw. If the game is still in progress, play continues until one of these conditions is met. <br/>
The "New Game" button resets the game board and the currentPlayer variable to their initial states, allowing the players to start a new game.


### Constants
The following constants are used in the TicTacToe class:

X_WON: String value "X won"
O_WON: String value "O won"
DRAW: String value "Draw"
IN_PROGRESS: String value "In progress"

## Console Game

### Console Configuration
The game consists of two classes:
- TicTacToe1
	- This class contains the core logic for the Tic Tac Toe game. It has a 2D array called board that represents the game board, as well as a currentPlayer variable to keep track of which player's turn it is.
	
  - The TicTacToe1 class has several methods:
  	- printBoard(): prints the current state of the game board to the console
  	- checkWin(char player): checks if the specified player has won the game by checking for three of their symbols in a row (horizontal, vertical, or diagonal)
  	- isDraw(): checks if the game is a draw by checking if all spaces on the board are occupied

- ConsoleMain
	- This class contains the main method that runs the game. It creates an instance of the TicTacToe1 class and uses its methods to play the game. Players are prompted to enter their moves through the command line and the game board is displayed after each turn. The game ends when a player wins or the game is a draw.


### Console Gameplay
The game is played through the command line, where players are prompted to enter the row and column for their next move. If a player attempts to place their symbol on a space that is already occupied, they will be re-prompted to enter a new move. <br/>
The game ends when a player wins or the game is a draw. The game board is displayed after each turn.

