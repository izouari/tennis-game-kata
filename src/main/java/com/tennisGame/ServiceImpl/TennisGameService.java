package com.tennisGame.ServiceImpl;

import org.springframework.stereotype.Service;

import com.tennisGame.Utils.Utils;
import com.tennisGame.model.Player;
import com.tennisGame.model.State;
import com.tennisGame.service.TennisService;

@Service
public class TennisGameService implements TennisService {

	/* 
	 * get the score of one Game
	 */
	public String getScore(Player playerOne, Player playerTwo, String... score) {

		if (Utils.hasWinner(playerOne, playerTwo, 4)) {
			return playerWithHighestScore(playerOne, playerTwo) + " " + State.WINS.getName();
		}

		if (Utils.hasAdvantage(playerOne, playerTwo, 4)) {
			return State.ADVANTAGE.getName() + " " + playerWithHighestScore(playerOne, playerTwo);
		}

		if (isDeuce(playerOne, playerTwo))
			return State.DEUCE.getName();

		if (playerOne.getScore() == playerTwo.getScore()) {
			return translateScore(playerOne.getScore()) + " all";
		}

		return translateScore(playerOne.getScore()) + "," + translateScore(playerTwo.getScore());
	}

	private boolean isDeuce(Player playerOne, Player playerTwo) {
		return playerOne.getScore() >= 3 && playerTwo.getScore() == playerOne.getScore();
	}

	private String translateScore(int score) {
		switch (score) {
		case 3:
			return "Forty";
		case 2:
			return "Thirty";
		case 1:
			return "Fifteen";
		case 0:
			return "Love";
		}
		throw new IllegalArgumentException("Illegal score: " + score);
	}
}
