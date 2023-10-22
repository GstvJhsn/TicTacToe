package se.his.it401g.game_project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 * @author Student - Gustav Johansson - DVSUG20G - University of Skövde
 */

/*
 * This class is represents the JFrame where the game takes place.
 * 
 */
public class Frame extends JFrame implements ActionListener {

	/*
	 * Local variables to store the status of the game.
	 */
	private JTextField titleField;
	private JTextField statusField;
	private JPanel titlePanel;
	private JPanel statusPanel;

	/*
	 * JButton used if you want to play again.
	 */
	private JButton restart = new JButton("Restart");

	/*
	 * Objects
	 */
	private TicTacToe ticTacToe;
	private Square square = new Square();
	private Circle circle = new Circle();
	private GameEngine game;

	Frame() {

		statusField = new JTextField();
		ticTacToe = new TicTacToe();
		game = new GameEngine(this, ticTacToe);

		titleField = new JTextField();
		titleField.setText("Tic-Tac-Toe");
		titleField.setEditable(false);
		titleField.setFocusable(false);
		titleField.setBackground(new Color(15, 21, 28));
		titleField.setFont(new Font("Comic Sans", Font.BOLD, 25));
		titleField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		titleField.setForeground(Color.orange);

		statusField.setEditable(false);
		statusField.setFocusable(false);
		statusField.setBackground(new Color(15, 21, 28));
		statusField.setFont(new Font("Comic Sans", Font.BOLD, 25));
		statusField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		statusField.setForeground(Color.orange);

		restart.setFocusable(true);
		restart.setBackground(Color.ORANGE);
		restart.addActionListener(this);
		restart.setVisible(false);

		titlePanel = new JPanel();
		titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		titlePanel.setBackground(new Color(15, 21, 28));
		titlePanel.setPreferredSize(new Dimension(3, 70));
		titlePanel.add(titleField, BorderLayout.CENTER);

		statusPanel = new JPanel();
		statusPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		statusPanel.setBackground(new Color(15, 21, 28));
		statusPanel.setPreferredSize(new Dimension(3, 140));
		statusPanel.add(statusField, BorderLayout.SOUTH);
		statusPanel.add(restart, BorderLayout.CENTER);

		this.pack();
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Image icon = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB_PRE);
		this.setIconImage(icon);
		this.setLayout(new BorderLayout());
		this.setSize(600, 800);
		this.add(ticTacToe, BorderLayout.SOUTH);
		this.add(statusPanel, BorderLayout.CENTER);
		this.add(titlePanel, BorderLayout.NORTH);

		this.setVisible(true);
		validateFrame();

	}

	/*
	 * Method that add the restart button to the panel
	 */
	public void addRestart() {
		restart = new JButton("Restart");
		restart.setFocusable(false);
		restart.setBackground(Color.ORANGE);
		restart.setVisible(false);
		statusPanel.add(restart, BorderLayout.CENTER);
	}

	/*
	 * Getters and Setters
	 */
	public void setStatusField(String text) {
		statusField.setText(text);
	}

	public JTextField getStatusField() {
		return statusField;
	}

	public JButton getRestart() {
		return restart;
	}

	public void validateFrame() {
		SwingUtilities.updateComponentTreeUI(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == restart) {
			this.dispose();
			Frame frame = new Frame();
			game = new GameEngine(frame, ticTacToe);
		}

	}

}
