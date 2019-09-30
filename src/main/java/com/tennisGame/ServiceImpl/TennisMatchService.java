package com.tennisGame.ServiceImpl;

import org.springframework.stereotype.Service;

import com.tennisGame.Utils.Utils;
import com.tennisGame.model.Player;
import com.tennisGame.model.State;
import com.tennisGame.service.TennisService;

@Service
public class TennisMatchService implements TennisService {

	/* 
	 * get the score of the match
	 */
	public String getScore(Player playerOne, Player playerTwo, String... score) {
		Utils.createScore(playerOne, playerTwo, score);
		int totalNumberOfSet = playerOne.getNumberOfset().size();
		int numberSetPlayer1 = 0;
		int numberSetPlayer2 = 0;
		for (int i = 1; i <= totalNumberOfSet; i++) {
			int scorePlayer1 = playerOne.getNumberOfset().get(i);
			int scorePlayer2 = playerTwo.getNumberOfset().get(i);
			if (scorePlayer1 == 6 || scorePlayer1 == 7 || scorePlayer2 == 6 || scorePlayer2 == 7) {
				if (scorePlayer1 > scorePlayer2)
					numberSetPlayer1++;
				else
					numberSetPlayer2++;
			}
		}
		if (numberSetPlayer1 == 3) {
			
			return playerOne.getName() + " " + State.WINS.getName();
		} else if (numberSetPlayer2 == 3) {
			return playerTwo.getName() + " " + State.WINS.getName();
		}

		return State.INPROGRESS.getName();
	}

}
