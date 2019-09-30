package com.tennisGame.model;

import java.util.List;

public class PlayerMatch {

	private List<Player> players;
	private String[] score;

	public PlayerMatch() {
		// TODO Auto-generated constructor stub
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public String[] getScore() {
		return score;
	}

	public void setScore(String[] score) {
		this.score = score;
	}

}
