package com.game.sal.exceptions;

public class TooFewPlayersException extends IllegalArgumentException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public String getMessage() {
		return "Too few players";
	}
}
