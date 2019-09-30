package com.tennisGame.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tennisGame.ServiceImpl.TennisMatchService;
import com.tennisGame.model.Player;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TennisMatchTest {

	@Autowired
	TennisMatchService match;
	Player playerOne;
	Player playerTwo;

	@Before
	public void init() {
		playerOne = new Player("Roger Federer");
		playerTwo = new Player("Nadal");
	}

	@Test
	public void testPlayerOneWinMatch() {
		String[] scores = { "(7-5)", "(6-4)", "(6-3)" };
		com.tennisGame.Utils.Utils.createScore(playerOne, playerTwo, scores);
		String score = match.getScore(playerOne, playerTwo, scores);
		assertEquals("Roger Federer wins", score);
	}

	@Test
	public void testPlayerTwoWinMatch() {
		String[] scores = { "(4-6)", "(1-6)", "(6-4)", "(6-4)", "(3-6)" };
		com.tennisGame.Utils.Utils.createScore(playerOne, playerTwo, scores);
		String score = match.getScore(playerOne, playerTwo, scores);
		assertEquals("Nadal wins", score);
	}

	@Test
	public void testMatchInProgress() {
		String[] scores = { "(7-5)", "(6-4)", "(0-0)" };
		com.tennisGame.Utils.Utils.createScore(playerOne, playerTwo, scores);
		String score = match.getScore(playerOne, playerTwo, scores);
		assertEquals("in progress", score);
	}

}
