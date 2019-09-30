package com.tennisGame.ServiceImpl;

import org.springframework.stereotype.Service;

import com.tennisGame.Utils.Utils;
import com.tennisGame.model.Player;
import com.tennisGame.model.State;
import com.tennisGame.service.TennisService;

@Service
public class TennisSetService implements TennisService {

	/*
	 * get the score of the set
	 */
	public String getScore(Player playerOne, Player playerTwo, String... score) {

		if (Utils.hasWinner(playerOne, playerTwo, 6)) {
			return playerWithHighestScore(playerOne, playerTwo) + " " + State.WINS.getName();
		}
		if (isTieBreak(playerOne, playerTwo)) {
			return State.TIEBREAK.getName();
		}

		if (Utils.hasAdvantage(playerOne, playerTwo, 5)) {
			return State.ADVANTAGE.getName() + " " + playerWithHighestScore(playerOne, playerTwo);
		}
		if (hasTieBreakAdvantage(playerOne, playerTwo)) {
			return State.ADVANTAGE.getName() + " " + playerWithHighestTBScore(playerOne, playerTwo);
		}
		if (hasWinnerAfterTieBreak(playerOne, playerTwo)) {
			return playerWithHighestTBScore(playerOne, playerTwo) + " " + State.WINS.getName();
		}

		if (playerOne.getScore() == playerTwo.getScore()) {
			return playerOne.getScore() + " all";
		}

		return playerOne.getScore() + "," + playerTwo.getScore();
	}

	/**
	 * method to check if the playerOne and playerTwo will Play the Tie Break or
	 * not
	 * 
	 * @param playerOne
	 * @param playerTwo
	 * @return
	 */
	private boolean isTieBreak(Player playerOne, Player playerTwo) {
		return playerOne.getScore() == 6 && playerTwo.getScore() == playerOne.getScore()
				&& playerOne.getTieBreakScore() == 0 && playerTwo.getTieBreakScore() == 0;
	}

	/**
	 * method to check which Player win in the Tie Break
	 * @param playerOne
	 * @param playerTwo
	 * @return
	 */
	private boolean hasWinnerAfterTieBreak(Player playerOne, Player playerTwo) {
		if (playerOne.getScore() == 6 && playerTwo.getScore() == 6) {
			if (playerTwo.getTieBreakScore() >= 7 && playerTwo.getTieBreakScore() >= playerOne.getTieBreakScore() + 2)
				return true;
			if (playerOne.getTieBreakScore() >= 7 && playerOne.getTieBreakScore() >= playerTwo.getTieBreakScore() + 2)
				return true;
		}
		return false;
	}

	private boolean hasTieBreakAdvantage(Player playerOne, Player playerTwo) {
		if (playerOne.getScore() == 6 && playerTwo.getScore() == 6) {
			if (playerTwo.getTieBreakScore() >= 6 && playerTwo.getTieBreakScore() == playerOne.getTieBreakScore() + 1)
				return true;
			if (playerOne.getTieBreakScore() >= 6 && playerOne.getTieBreakScore() == playerTwo.getTieBreakScore() + 1)
				return true;
		}

		return false;

	}

}
