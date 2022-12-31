package domain;

import java.util.Scanner;

public class ConsoleMain {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				TicTacToe1.board[i][j] = ' ';
			}
		}

		TicTacToe1.printBoard();

		while (true) {
			System.out.print("Enter row (0, 1, 2) for player " + TicTacToe1.currentPlayer + ": ");
			int row = input.nextInt();
			System.out.print("Enter column (0, 1, 2) for player " + TicTacToe1.currentPlayer + ": ");
			int col = input.nextInt();

			while (TicTacToe1.board[row][col] != ' ') {// if that position is not empty, re-prompt user
				System.out.println("Postion already taken");
				System.out.print("Re-enter row (0, 1, 2) for player " + TicTacToe1.currentPlayer + ": ");
				row = input.nextInt();
				System.out.print("Re-Enter column (0, 1, 2) for player " + TicTacToe1.currentPlayer + ": ");
				col = input.nextInt();
			}

			TicTacToe1.board[row][col] = TicTacToe1.currentPlayer;

			if (TicTacToe1.checkWin(TicTacToe1.currentPlayer)) {
				System.out.println("Player " + TicTacToe1.currentPlayer + " wins!");
				break;
			}
			if (TicTacToe1.isDraw()) {
				System.out.println("The game is a draw.");
				break;
			}
			TicTacToe1.currentPlayer = (TicTacToe1.currentPlayer == 'X') ? 'O' : 'X';
			TicTacToe1.printBoard();
		}
	}
}
