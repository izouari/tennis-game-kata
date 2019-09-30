package com.tennisGame.model;

import java.util.HashMap;
import java.util.Map;


public class Player {
	private int score;
	private String name;
	private int tieBreakScore;
	private Map<Integer, Integer> numberOfset;

	public Player() {
	}

	public Player(String playerName) {
		super();
		this.name = playerName;
	}

	public String getName() {
		return name;
	}

	public void setName(String playerName) {
		this.name = playerName;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int playerScore) {
		this.score = playerScore;
	}

	public int getTieBreakScore() {
		return tieBreakScore;
	}

	public void setTieBreakScore(int tieBreakScore) {
		this.tieBreakScore = tieBreakScore;
	}

	public Map<Integer, Integer> getNumberOfset() {
		if (this.numberOfset == null) {
			numberOfset = new HashMap<Integer, Integer>();
		}
		return numberOfset;
	}

	public void setNumberOfset(Map<Integer, Integer> numberOfset) {
		this.numberOfset = numberOfset;
	}

}
