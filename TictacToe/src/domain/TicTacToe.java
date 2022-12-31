package domain;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TicTacToe extends JFrame implements ActionListener {
	private static final String X_WON = "X won";
	private static final String O_WON = "O won";
	private static final String DRAW = "Draw";
	private static final String IN_PROGRESS = "In progress";
	private JButton[][] buttons;
	private JButton newGameButton;
	private String currentPlayer;

	// class variables go here
	public TicTacToe() {
		// set up the GUI
		setTitle("Tic Tac Toe");
		setSize(400, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(3, 3));

		// create the game board
		buttons = new JButton[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				buttons[i][j] = new JButton();
				buttons[i][j].addActionListener(this);
				add(buttons[i][j]);
			}
		}

		// create the "New Game" button
		newGameButton = new JButton("New Game");
		newGameButton.addActionListener(this);
		add(newGameButton);

		setVisible(true);

	}

	private String checkGameStatus() {
		// check rows for a win
		for (int i = 0; i < 3; i++) {
			if (!buttons[i][0].getText().equals("") && buttons[i][0].getText().equals(buttons[i][1].getText())
					&& buttons[i][1].getText().equals(buttons[i][2].getText())) {
				return buttons[i][0].getText() + " won";
			}
		}

		// check columns for a win
		for (int i = 0; i < 3; i++) {
			if (!buttons[0][i].getText().equals("") && buttons[0][i].getText().equals(buttons[1][i].getText())
					&& buttons[1][i].getText().equals(buttons[2][i].getText())) {
				return buttons[0][i].getText() + " won";
			}
		}

		// check diagonals for a win
		if (!buttons[0][0].getText().equals("") && buttons[0][0].getText().equals(buttons[1][1].getText())
				&& buttons[1][1].getText().equals(buttons[2][2].getText())) {
			return buttons[0][0].getText() + " won";
		}
		if (!buttons[0][2].getText().equals("") && buttons[0][2].getText().equals(buttons[1][1].getText())
				&& buttons[1][1].getText().equals(buttons[2][0].getText())) {
			return buttons[0][2].getText() + " won";
		}

		// check for a draw
		boolean isDraw = true;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (buttons[i][j].getText().equals("")) {
					isDraw = false;
				}
			}
		}
		if (isDraw) {
			return DRAW;
		}

		// game is still in progress
		return IN_PROGRESS;
	}

	public void actionPerformed(ActionEvent e) {
		// check if the "New Game" button was clicked
		if (e.getSource() == newGameButton) {
			// reset the game
			currentPlayer = "X";
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					buttons[i][j].setText("");
				}
			}
		} else {
			// a game board button was clicked
			JButton button = (JButton) e.getSource();
			if (button.getText().equals("")) {
				button.setText(currentPlayer);
				if (currentPlayer.equals("X")) {
					currentPlayer = "O";
				} else {
					currentPlayer = "X";
				}

				// check the game status
				String gameStatus = checkGameStatus();
				if (gameStatus.equals(X_WON)) {
					JOptionPane.showMessageDialog(this, "X won!");
				} else if (gameStatus.equals(O_WON)) {
					JOptionPane.showMessageDialog(this, "O won!");
				} else if (gameStatus.equals(DRAW)) {
					JOptionPane.showMessageDialog(this, "It's a draw!");
				}
			}
		}
	}

}
