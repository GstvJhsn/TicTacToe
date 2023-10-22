package se.his.it401g.game_project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;

/**
 * @author Student - Gustav Johansson - DVSUG20G - University of Skövde
 */

/*
 * Subclass to Board. This class represents a Tic-Tac-Toe game board.
 */
public class TicTacToe extends Board {

	/*
	 * The Constructor which sets the size of the of the board, the layout, color
	 * size and creates the gameField.
	 */

	public TicTacToe() {
		setGameBoxes(new JButton[9]);
		formatBoard();
		createGameField();
	}

	/*
	 * Method when called, draws a game-piece to the gameBox;
	 */

	public void drawToBoard(Piece piece, int iterator) {
		getGameBoxes()[iterator].add(piece.getShape(), BorderLayout.CENTER);
		getGameBoxes()[iterator].setOpaque(true);

	}

	@Override
	public void formatBoard() {
		this.setLayout(new GridLayout(3, 3));
		this.setBackground(new Color(15, 21, 28));
		this.setPreferredSize(new Dimension(600, 600));

	}

}
