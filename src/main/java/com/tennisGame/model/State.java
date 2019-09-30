package com.tennisGame.model;

public enum State {
	
	ADVANTAGE("Advantage"), 
	DEUCE("Deuce"), 
	INPROGRESS("in progress"),
	TIEBREAK("Tie-Break"), 
	WINS("wins");

	private final String name;

	private State(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
