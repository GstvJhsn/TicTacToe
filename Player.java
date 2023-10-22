package se.his.it401g.game_project;

/**
 * @author Student - Gustav Johansson - DVSUG20G - University of Skövde
 */

/**
 * This class represents the Players of the game.
 */
public class Player {
	/**
	 * Boolean value used to determine which player turn it is
	 */
	private boolean isPlayerTurn;
	private String playerName;

	Player(String playerName) {
		this.playerName = playerName;
	}

	/**
	 * Getters
	 */
	boolean getIsPlayerTurn() {
		return isPlayerTurn;
	}

	public String getPlayerName() {
		return playerName;
	}

	/**
	 * Setters
	 */
	void playerTurn() {
		isPlayerTurn = true;
	}

	void notPlayerTurn() {
		isPlayerTurn = false;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

}
