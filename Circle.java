package se.his.it401g.game_project;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;

/**
 * @author Student - Gustav Johansson - DVSUG20G - University of Skövde
 */

/*
 * Subclass to Piece. This class represents a Circle game piece.
 */
public class Circle extends Piece {

	/*
	 * JLabel representing the Piece;
	 */
	private JLabel circle;

	public Circle() {
		createShape();
		setShape(circle);
	}

	/*
	 * Overridden method createShape used to define the shape of the piece
	 */
	@Override
	public void createShape() {
		circle = new JLabel();
		circle.setLayout(new FlowLayout(FlowLayout.CENTER));
		circle.setBackground(Color.DARK_GRAY);
		circle.setForeground(new Color(255, 69, 0));
		circle.setText("O");
		circle.setFont(new Font("Comic Sans", Font.BOLD, 70));

	}
}
