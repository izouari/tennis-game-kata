package com.tennisGame.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tennisGame.ServiceImpl.TennisSetService;
import com.tennisGame.Utils.Utils;
import com.tennisGame.model.Player;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TennisSetTest {

	@Autowired
	TennisSetService set;
	Player playerOne;
	Player playerTwo;

	@Before
	public void init() {
		playerOne = new Player("Roger Federer");
		playerTwo = new Player("Nadal");
	}

	@Test
	public void testPlayerOneWinsset() {
		Utils.createScore(playerOne, playerTwo, 6, 0);

		String score = set.getScore(playerOne, playerTwo);
		assertEquals("Roger Federer wins", score);
	}

	@Test
	public void testPlayerTwoWinsset() {
		Utils.createScore(playerOne, playerTwo, 1, 6);

		String score = set.getScore(playerOne, playerTwo);
		assertEquals("Nadal wins", score);
	}

	@Test
	public void testPlayerOneAdvantage() {
		Utils.createScore(playerOne, playerTwo, 5, 4);

		String score = set.getScore(playerOne, playerTwo);
		assertEquals("Advantage Roger Federer", score);
	}

	@Test
	public void testPlayerTwoAdvantage() {
		Utils.createScore(playerOne, playerTwo, 4, 5);

		String score = set.getScore(playerOne, playerTwo);
		assertEquals("Advantage Nadal", score);
	}

	@Test
	public void testTieBreakStart() {
		Utils.createScore(playerOne, playerTwo, 6, 6);

		String score = set.getScore(playerOne, playerTwo);
		assertEquals("Tie-Break", score);
	}

	@Test
	public void testPlayerTwoAdvantageTB() {
		Utils.createScore(playerOne, playerTwo, 6, 6);
		Utils.createScore(playerOne, playerTwo, 5, 6, true);

		String score = set.getScore(playerOne, playerTwo);
		assertEquals("Advantage Nadal", score);
	}

	@Test
	public void testPlayerOneAdvantageTB() {
		Utils.createScore(playerOne, playerTwo, 6, 6);
		Utils.createScore(playerOne, playerTwo, 9, 8, true);

		String score = set.getScore(playerOne, playerTwo);
		assertEquals("Advantage Roger Federer", score);
	}

	@Test
	public void testPlayerTwoWinsAfterTieBreak() {
		Utils.createScore(playerOne, playerTwo, 6, 6);
		Utils.createScore(playerOne, playerTwo, 5, 7, true);

		String score = set.getScore(playerOne, playerTwo);
		assertEquals("Nadal wins", score);
	}

	@Test
	public void testPlayerOneWinsAfterTieBreak() {
		Utils.createScore(playerOne, playerTwo, 6, 6);
		Utils.createScore(playerOne, playerTwo, 9, 7, true);

		String score = set.getScore(playerOne, playerTwo);
		assertEquals("Roger Federer wins", score);
	}

}