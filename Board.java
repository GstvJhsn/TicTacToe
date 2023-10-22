package se.his.it401g.game_project;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * @author Student - Gustav Johansson - DVSUG20G - University of Skövde
 */

/**
 * This is the abstract class which represents the components of the board. This
 * class can be used to create different types of boards.
 */

public abstract class Board extends JPanel implements BoardFormat {

	/*
	 * Array of JButtons that represents the game boxes of the game.
	 */
	private JButton[] gameBoxes;

	/*
	 * Getters and setters
	 */
	public JButton[] getGameBoxes() {
		return gameBoxes;
	}

	protected void setGameBoxes(JButton[] gameBoxes) {
		this.gameBoxes = gameBoxes;
	}

	/*
	 * Method that creates the game field
	 */
	protected void createGameField() {

		for (int i = 0; i < gameBoxes.length; i++) {
			gameBoxes[i] = new JButton();
			gameBoxes[i].setFocusable(false);
			gameBoxes[i].setLayout(new BorderLayout());
			gameBoxes[i].setBackground(new Color(20, 28, 38));
			this.add(gameBoxes[i]);
		}

	}

}
