package se.his.it401g.game_project;

/**
 * @author Student - Gustav Johansson - DVSUG20G - University of Skövde
 */

/*
 * The main class starts the game by instantiating the GameEngine class;
 */
public class Main {

	public static void main(String[] args) {

		new GameEngine(new Frame(), new TicTacToe());

	}

}
