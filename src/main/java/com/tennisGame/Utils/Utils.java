package com.tennisGame.Utils;

import com.tennisGame.model.Player;

public class Utils {

	public static void playerScore(Player player) {
		int score = player.getScore();
		score++;
		player.setScore(score);
	}

	public static void playerTieBreakScore(Player player) {
		int score = player.getTieBreakScore();
		score++;
		player.setTieBreakScore(score);
	}

	public static boolean hasWinner(Player playerOne, Player playerTwo, int limit) {
		if (playerTwo.getScore() >= limit && playerTwo.getScore() >= playerOne.getScore() + 2)
			return true;
		if (playerOne.getScore() >= limit && playerOne.getScore() >= playerTwo.getScore() + 2)
			return true;
		return false;
	}

	public static boolean hasAdvantage(Player playerOne, Player playerTwo, int limit) {
		if (playerTwo.getScore() >= 4 && playerTwo.getScore() == playerOne.getScore() + 1)
			return true;
		if (playerOne.getScore() >= 4 && playerOne.getScore() == playerTwo.getScore() + 1)
			return true;

		return false;

	}

	/**
	 * method aim to create score (of set or of game) in unit Test
	 * @param playerOne
	 * @param playerTwo
	 * @param playerOneBalls
	 * @param playerTwoBalls
	 * @param isTieBreak
	 */
	public static void createScore(Player playerOne, Player playerTwo, int playerOneBalls, int playerTwoBalls,
			boolean... isTieBreak) {
		for (int i = 0; i < playerOneBalls; i++) {
			if (isTieBreak.length > 0)
				Utils.playerTieBreakScore(playerOne);
			else
				Utils.playerScore(playerOne);

		}
		for (int i = 0; i < playerTwoBalls; i++) {
			if (isTieBreak.length > 0)
				Utils.playerTieBreakScore(playerTwo);
			else
				Utils.playerScore(playerTwo);

		}
	}

	/**
	 * method aim to create score of match in unit Test
	 * @param playerOne
	 * @param playerTwo
	 * @param score
	 */
	public static void createScore(Player playerOne, Player playerTwo, String... score) {
		int i = 1;
		for (String s : score) {
			if (!s.isEmpty()) {
				String result = s.replaceAll("[()]", "");
				String[] array = result.split("-");
				playerOne.getNumberOfset().put(i, Integer.parseInt(array[0]));
				playerTwo.getNumberOfset().put(i, Integer.parseInt(array[1]));
				i++;
			}
		}
	}

}
