package main.actor;

/**
 * Player class.
 * Creates a player that the user will use in the game.
 */

public class Player {
	
	/** 
	 * The name of the player.
	 */
	private String playerName;
	
	/**
	 * Difficulty of the game.
	 */
	private String gameDifficulty;
	
	/** 
	 * Number of days the player wishes to play for.
	 */
	private int numOfDays;
	
	/**
	 * Number of days the player has played.
	 */
	private int currentDay = 1;

	/**
	* Player's score in the game.
	*/
	private int gameScore = 0;
	
	/**
	 * The constructor class for Player.
	 * @param name player name
	 * @param difficulty game difficulty
	 * @param days how many days the game goes on for
	 */
	public Player(String name, String difficulty, int days) {
		playerName = name;
		gameDifficulty = difficulty;
		numOfDays = days;
	}
	
	/**
	 * Gets the player's name.
	 * @return the {@link playerName}
	 */
	public String getPlayerName() {
		return playerName;
	}
	
	/**
	 * Gets game difficulty.
	 * @return the {@link gameDifficulty}
	 */
	public String getGameDifficulty() {
		return gameDifficulty;
	}
	
	/**
	 * Gets number of days.
	 * @return the {@link numOfDays}
	 */
	public int getNumOfDays() {
		return numOfDays;
	}
	
	/**
	 * Gets the day player is currently on.
	 * @return the {@link currentDay}
	 */
	public int getCurrentDay() {
		return currentDay;
	}

	/**
	* Gets player's game score.
	@return the {@link gameScore}
	*/
	public int getGameScore() {
		return gameScore;
	}
	
	/**
	 * Increases the player's current day by one.
	 */
	public void addDay() {
		currentDay ++;
	}
 	
	 /**
	 * Adds to player's score total.
	 * @param score the amount to add to player's current score
	 */
	public void addScore(int score) {
		gameScore += score;
	}
}
