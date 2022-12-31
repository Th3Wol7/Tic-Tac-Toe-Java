package tictactoe;

/*@author: Tyrien Gilpin
 * Created December 31, 2022
 * Description: This class represents an implementation of 
 * the Tic Tac Toe Game using the console to play
 * This version is design for two human player and not one human against
 * a computer
 */

public class TicTacToe1 {
	static char[][] board = new char[3][3];
	static char currentPlayer = 'X';
	
	//Getters and setters
	public static char[][] getBoard() {
		return board;
	}


	public static void setBoard(char[][] board) {
		TicTacToe1.board = board;
	}


	public static char getCurrentPlayer() {
		return currentPlayer;
	}


	public static void setCurrentPlayer(char currentPlayer) {
		TicTacToe1.currentPlayer = currentPlayer;
	}


	public static void printBoard() {
		for (int i = 0; i < 3; i++) {
			System.out.println(" " + board[i][0] + " | " + board[i][1] + " | " + board[i][2]);
			if (i != 2) {
				System.out.println("-----------");
			}
		}
	}

	
	public static boolean checkWin(char player) {
		// check rows
		for (int i = 0; i < 3; i++) {
			if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
				return true;
			}
		}
		// check columns
		for (int i = 0; i < 3; i++) {
			if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
				return true;
			}
		}
		// check diagonals
		if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
			return true;
		}
		if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
			return true;
		}
		return false;
	}

	public static boolean isDraw() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == ' ') {
					return false;
				}
			}
		}
		return true;
	}
}
