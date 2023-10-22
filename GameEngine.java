package se.his.it401g.game_project;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Student - Gustav Johansson - DVSUG20G - University of Skövde
 */

/*
 * This class is the motor of the game. The class defines it's rules and
 * winning-conditions. The class also instantiates the needed classes for the
 * Tic-Tac-Toe game.
 */

public class GameEngine implements ActionListener {

	/*
	 * Objects that is needed for the game to run.
	 */
	private Player playerOne = new Player("Player One");
	private Player playerTwo = new Player("Player Two");
	private TicTacToe ticTacToe;
	private Frame frame;

	/*
	 * Used to calculate the number of moves
	 */
	private int nrOfMoves = 0;

	/*
	 * The Constructor that takes one frame object and one TicTacToe object as
	 * argument. Randomizes the player that starts. and adds action listeners to the
	 * buttons.
	 */
	GameEngine(Frame frame, TicTacToe ticTacToe) {
		this.frame = frame;
		this.ticTacToe = ticTacToe;
		startingPlayer().playerTurn();
		addActionListeners();

	}

	/*
	 * Local method used to add action listeners.
	 */
	private void addActionListeners() {
		for (int i = 0; i < ticTacToe.getGameBoxes().length; i++) {
			ticTacToe.getGameBoxes()[i].addActionListener(this);
		}

		frame.getRestart().addActionListener(this);
	}

	/*
	 * Local method that randomizes starting player.
	 */
	private Player startingPlayer() {
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(playerOne);
		players.add(playerTwo);
		Collections.shuffle(players);
		displayStartingPlayer(players.get(0).getPlayerName());
		return players.get(0);

	}

	/*
	 * Local method the displays the game result draw
	 */
	private void displayDraw() {
		frame.getStatusField().setText("You played a draw");
	}

	/*
	 * Local method the displays the starting player.
	 */
	private void displayStartingPlayer(String playerName) {
		frame.getStatusField().setText(playerName + "'s turn");
	}

	/*
	 * Local method the displays the game winning player.
	 */
	private void displayWinningPlayer(String playerName) {
		frame.getStatusField().setText(playerName + " Wins!");
	}

	/*
	 * Overridden method that defines the actions that is performed when different
	 * buttons is clicked.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		for (int i = 0; i < 9; i++) {
			if (e.getSource() == ticTacToe.getGameBoxes()[i]) {

				if (playerOne.getIsPlayerTurn() == true) {
					ticTacToe.drawToBoard(new Circle(), i);
					ticTacToe.getGameBoxes()[i].setText("Player One");
					ticTacToe.getGameBoxes()[i].setFont(new Font("Comic Sans", Font.ITALIC, 1));
					playerOne.notPlayerTurn();
					playerTwo.playerTurn();
					displayStartingPlayer(playerTwo.getPlayerName());
					ticTacToe.getGameBoxes()[i].setEnabled(false);
					nrOfMoves = nrOfMoves + 1;

				}

				else if (playerTwo.getIsPlayerTurn() == true) {

					ticTacToe.drawToBoard(new Square(), i);
					ticTacToe.getGameBoxes()[i].setText("Player Two");
					ticTacToe.getGameBoxes()[i].setFont(new Font("Comic Sans", Font.ITALIC, 1));
					playerTwo.notPlayerTurn();
					playerOne.playerTurn();
					displayStartingPlayer(playerOne.getPlayerName());
					ticTacToe.getGameBoxes()[i].setEnabled(false);
					nrOfMoves = nrOfMoves + 1;
				}
			}
		}

		checkPlayerOne();
		checkPlayerTwo();

		frame.validateFrame();
	}

	/*
	 * Checks if player two wins
	 */
	private void checkPlayerTwo() {
		if ((ticTacToe.getGameBoxes()[0].getText() == "Player Two")
				&& (ticTacToe.getGameBoxes()[1].getText() == "Player Two")
				&& (ticTacToe.getGameBoxes()[2].getText() == "Player Two")) {
			playerTwoWins(0, 1, 2);
		}

		if ((ticTacToe.getGameBoxes()[3].getText() == "Player Two")
				&& (ticTacToe.getGameBoxes()[4].getText() == "Player Two")
				&& (ticTacToe.getGameBoxes()[5].getText() == "Player Two")) {
			playerTwoWins(3, 4, 5);
		}

		if ((ticTacToe.getGameBoxes()[6].getText() == "Player Two")
				&& (ticTacToe.getGameBoxes()[7].getText() == "Player Two")
				&& (ticTacToe.getGameBoxes()[8].getText() == "Player Two")) {
			playerTwoWins(6, 7, 8);
		}

		if ((ticTacToe.getGameBoxes()[0].getText() == "Player Two")
				&& (ticTacToe.getGameBoxes()[3].getText() == "Player Two")
				&& (ticTacToe.getGameBoxes()[6].getText() == "Player Two")) {
			playerTwoWins(0, 3, 6);
		}

		if ((ticTacToe.getGameBoxes()[1].getText() == "Player Two")
				&& (ticTacToe.getGameBoxes()[4].getText() == "Player Two")
				&& (ticTacToe.getGameBoxes()[7].getText() == "Player Two")) {
			playerTwoWins(1, 4, 7);
		}

		if ((ticTacToe.getGameBoxes()[2].getText() == "Player Two")
				&& (ticTacToe.getGameBoxes()[5].getText() == "Player Two")
				&& (ticTacToe.getGameBoxes()[8].getText() == "Player Two")) {
			playerTwoWins(2, 5, 8);
		}

		if ((ticTacToe.getGameBoxes()[0].getText() == "Player Two")
				&& (ticTacToe.getGameBoxes()[4].getText() == "Player Two")
				&& (ticTacToe.getGameBoxes()[8].getText() == "Player Two")) {
			playerTwoWins(0, 4, 8);
		}
		if ((ticTacToe.getGameBoxes()[2].getText() == "Player Two")
				&& (ticTacToe.getGameBoxes()[4].getText() == "Player Two")
				&& (ticTacToe.getGameBoxes()[6].getText() == "Player Two")) {
			playerTwoWins(2, 4, 6);
		}

		else if (nrOfMoves == 9) {
			playedDraw();
		}

	}

	/*
	 * Checks if player one wins
	 */
	private void checkPlayerOne() {
		if ((ticTacToe.getGameBoxes()[0].getText() == "Player One")
				&& (ticTacToe.getGameBoxes()[1].getText() == "Player One")
				&& (ticTacToe.getGameBoxes()[2].getText() == "Player One")) {
			playerOneWins(0, 1, 2);
		}

		if ((ticTacToe.getGameBoxes()[3].getText() == "Player One")
				&& (ticTacToe.getGameBoxes()[4].getText() == "Player One")
				&& (ticTacToe.getGameBoxes()[5].getText() == "Player One")) {
			playerOneWins(3, 4, 5);
		}

		if ((ticTacToe.getGameBoxes()[6].getText() == "Player One")
				&& (ticTacToe.getGameBoxes()[7].getText() == "Player One")
				&& (ticTacToe.getGameBoxes()[8].getText() == "Player One")) {
			playerOneWins(6, 7, 8);
		}

		if ((ticTacToe.getGameBoxes()[0].getText() == "Player One")
				&& (ticTacToe.getGameBoxes()[3].getText() == "Player One")
				&& (ticTacToe.getGameBoxes()[6].getText() == "Player One")) {
			playerOneWins(0, 3, 6);
		}

		if ((ticTacToe.getGameBoxes()[1].getText() == "Player One")
				&& (ticTacToe.getGameBoxes()[4].getText() == "Player One")
				&& (ticTacToe.getGameBoxes()[7].getText() == "Player One")) {
			playerOneWins(1, 4, 7);
		}

		if ((ticTacToe.getGameBoxes()[2].getText() == "Player One")
				&& (ticTacToe.getGameBoxes()[5].getText() == "Player One")
				&& (ticTacToe.getGameBoxes()[8].getText() == "Player One")) {
			playerOneWins(2, 5, 8);
		}

		if ((ticTacToe.getGameBoxes()[0].getText() == "Player One")
				&& (ticTacToe.getGameBoxes()[4].getText() == "Player One")
				&& (ticTacToe.getGameBoxes()[8].getText() == "Player One")) {
			playerOneWins(0, 4, 8);
		}
		if ((ticTacToe.getGameBoxes()[2].getText() == "Player One")
				&& (ticTacToe.getGameBoxes()[4].getText() == "Player One")
				&& (ticTacToe.getGameBoxes()[6].getText() == "Player One")) {
			playerOneWins(2, 4, 6);
		} else if (nrOfMoves == 9) {
			playedDraw();
		}

	}

	/*
	 * Local method that is called when player one wins.
	 */
	private void playerOneWins(int a, int b, int c) {
		ticTacToe.getGameBoxes()[a].setBackground(Color.GREEN);
		ticTacToe.getGameBoxes()[b].setBackground(Color.GREEN);
		ticTacToe.getGameBoxes()[c].setBackground(Color.GREEN);
		for (int i = 0; i < ticTacToe.getGameBoxes().length; i++) {
			ticTacToe.getGameBoxes()[i].setEnabled(false);

		}
		displayWinningPlayer(playerOne.getPlayerName());
		frame.getRestart().setVisible(true);
	}

	/*
	 * Local method that is called when player two wins.
	 */
	private void playerTwoWins(int a, int b, int c) {
		ticTacToe.getGameBoxes()[a].setBackground(Color.GREEN);
		ticTacToe.getGameBoxes()[b].setBackground(Color.GREEN);
		ticTacToe.getGameBoxes()[c].setBackground(Color.GREEN);
		for (int i = 0; i < ticTacToe.getGameBoxes().length; i++) {
			ticTacToe.getGameBoxes()[i].setEnabled(false);

		}
		displayWinningPlayer(playerTwo.getPlayerName());
		frame.getRestart().setVisible(true);
	}

	/*
	 * Local method that is called when draw.
	 */
	private void playedDraw() {
		displayDraw();
		frame.getRestart().setVisible(true);
	}

}
