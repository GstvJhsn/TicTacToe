package se.his.it401g.game_project;

import javax.swing.JLabel;

/**
 * @author Student - Gustav Johansson - DVSUG20G - University of Skövde
 */

/**
 * This is the abstract class which represents the game pieces used in the game.
 * This class can be used to create different types of pieces. The class
 * implements the Shape interface to access the createShape() method.
 */
public abstract class Piece implements Shape {

	/*
	 * JLabel that represents the shape of Piece
	 */
	private JLabel shape;

	/*
	 * Getters and setters
	 */
	public JLabel getShape() {
		return shape;
	}

	public void setShape(JLabel shape) {
		this.shape = shape;
	}

}
