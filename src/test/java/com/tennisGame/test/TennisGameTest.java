package com.tennisGame.test;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.tennisGame.ServiceImpl.TennisGameService;
import com.tennisGame.Utils.Utils;
import com.tennisGame.model.Player;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TennisGameTest {

	@Autowired
	private TennisGameService game;
	Player playerOne;
	Player playerTwo;

	@Before
	public void init() {
		playerOne = new Player("Roger Federer");
		playerTwo = new Player("Nadal");
	}

	@Test
	public void testNewGameShouldReturnLoveAll() {
		String score = game.getScore(playerOne, playerTwo);

		assertEquals("Love all", score);
	}

	@Test
	public void testPlayerOneWinsFirstBall() {
		Utils.playerScore(playerOne);

		String score = game.getScore(playerOne, playerTwo);
		assertEquals("Fifteen,Love", score);
	}

	@Test
	public void testFifteenAll() {
		Utils.playerScore(playerOne);
		Utils.playerScore(playerTwo);

		String score = game.getScore(playerOne, playerTwo);
		assertEquals("Fifteen all", score);
	}

	@Test
	public void testPlayerTwoWinsFirstTwoBalls() {
		Utils.createScore(playerOne, playerTwo, 0, 2);

		String score = game.getScore(playerOne, playerTwo);
		assertEquals("Love,Thirty", score);
	}

	@Test
	public void testPlayerOneWinsFirstThreeBalls() {
		Utils.createScore(playerOne, playerTwo, 3, 0);
		String score = game.getScore(playerOne, playerTwo);
		assertEquals("Forty,Love", score);
	}

	@Test
	public void testPlayersAreDeuce() {
		Utils.createScore(playerOne, playerTwo, 3, 3);

		String score = game.getScore(playerOne, playerTwo);
		assertEquals("Deuce", score);
	}

	@Test
	public void testPlayerOneWinsGame() {
		Utils.createScore(playerOne, playerTwo, 4, 0);

		String score = game.getScore(playerOne, playerTwo);
		assertEquals("Roger Federer wins", score);
	}

	@Test
	public void testPlayerTwoWinsGame() {
		Utils.createScore(playerOne, playerTwo, 1, 4);

		String score = game.getScore(playerOne, playerTwo);
		assertEquals("Nadal wins", score);
	}

	@Test
	public void testPlayersAreDuce4() {
		Utils.createScore(playerOne, playerTwo, 4, 4);
		String score = game.getScore(playerOne, playerTwo);
		assertEquals("Deuce", score);
	}

	@Test
	public void testPlayerTwoAdvantage() {
		Utils.createScore(playerOne, playerTwo, 4, 5);

		String score = game.getScore(playerOne, playerTwo);
		assertEquals("Advantage Nadal", score);
	}

	@Test
	public void testPlayerOneAdvantage() {
		Utils.createScore(playerOne, playerTwo, 5, 4);

		String score = game.getScore(playerOne, playerTwo);
		assertEquals("Advantage Roger Federer", score);
	}

	@Test
	public void testPlayerTwoWins() {
		Utils.createScore(playerOne, playerTwo, 2, 4);
		String score = game.getScore(playerOne, playerTwo);
		assertEquals("Nadal wins", score);
	}

	@Test
	public void testPlayerTwoWinsAfterAdvantage() {
		Utils.createScore(playerOne, playerTwo, 6, 8);
		String score = game.getScore(playerOne, playerTwo);
		assertEquals("Nadal wins", score);
	}

	@Test
	public void testPlayerOneWinsAfterAdvantage() {
		Utils.createScore(playerOne, playerTwo, 8, 6);
		String score = game.getScore(playerOne, playerTwo);
		assertEquals("Roger Federer wins", score);
	}

}
