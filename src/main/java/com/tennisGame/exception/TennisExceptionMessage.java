package com.tennisGame.exception;

public enum TennisExceptionMessage {
	
	INVALID_PLAYERS_LIST("TEN001", "Invalide Players List, Players List should contain exactly two players"),
	SCORE_MISSED("TEN002", "the Score is Missed, it's needed to calculate the winner of match");

	
	private TennisExceptionMessage(String code, String description) {
		this.code = code;
		this.description = description;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}



	private String code;
	private String description;

}
