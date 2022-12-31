package domain;

import java.util.Scanner;

import tictactoe.TicTacToe1;

public class ConsoleMain {
	static Scanner input = new Scanner(System.in);
	static char[][] board = new char[3][3];
	
	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				TicTacToe1.getBoard()[i][j] = ' ';
			}
		}

		TicTacToe1.printBoard();

		while (true) {
			System.out.print("Enter row (0, 1, 2) for player " + TicTacToe1.getCurrentPlayer() + ": ");
			int row = input.nextInt();
			System.out.print("Enter column (0, 1, 2) for player " + TicTacToe1.getCurrentPlayer() + ": ");
			int col = input.nextInt();

			while (TicTacToe1.getBoard()[row][col] != ' ') {// if that position is not empty, re-prompt user
				System.out.println("Postion already taken");
				System.out.print("Re-enter row (0, 1, 2) for player " + TicTacToe1.getCurrentPlayer() + ": ");
				row = input.nextInt();
				System.out.print("Re-Enter column (0, 1, 2) for player " + TicTacToe1.getCurrentPlayer() + ": ");
				col = input.nextInt();
			}

			TicTacToe1.getBoard()[row][col] = TicTacToe1.getCurrentPlayer();

			if (TicTacToe1.checkWin(TicTacToe1.getCurrentPlayer())) {
				System.out.println("Player " + TicTacToe1.getCurrentPlayer() + " wins!");
				break;
			}
			if (TicTacToe1.isDraw()) {
				System.out.println("The game is a draw.");
				break;
			}
			TicTacToe1.setCurrentPlayer((char) ((TicTacToe1.getCurrentPlayer() == 'X') ? 'O' : 'X'));
			TicTacToe1.printBoard();
		}
	}
}
