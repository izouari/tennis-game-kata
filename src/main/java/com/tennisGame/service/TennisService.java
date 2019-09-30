package com.tennisGame.service;

import com.tennisGame.model.Player;

public interface TennisService {

	String getScore(Player playerOne, Player playerTwo, String... score);

	default String playerWithHighestScore(Player playerOne, Player playerTwo) {
		if (playerOne.getScore() > playerTwo.getScore()) {
			return playerOne.getName();
		} else {
			return playerTwo.getName();
		}
	}

	default String playerWithHighestTBScore(Player playerOne, Player playerTwo) {
		if (playerOne.getTieBreakScore() > playerTwo.getTieBreakScore()) {
			return playerOne.getName();
		} else {
			return playerTwo.getName();
		}
	}

}
