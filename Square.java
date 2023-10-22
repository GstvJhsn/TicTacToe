package se.his.it401g.game_project;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;

/**
 * @author Student - Gustav Johansson - DVSUG20G - University of Skövde
 */

/*
 * Subclass to Piece. This class represents a Square game piece.
 */
public class Square extends Piece {

	/*
	 * JLabel representing the Piece;
	 */
	private JLabel square;

	Square() {
		createShape();
		setShape(square);
	}

	/*
	 * Overridden method createShape used to define the shape of the piece
	 */
	@Override
	public void createShape() {
		square = new JLabel();
		square.setLayout(new FlowLayout(FlowLayout.CENTER));
		square.setBackground(Color.DARK_GRAY);
		square.setForeground(new Color(255, 103, 0));
		square.setText("#");
		square.setFont(new Font("Comic Sans", Font.BOLD, 70));

	}

}
