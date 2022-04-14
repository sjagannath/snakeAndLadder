package com.game.sal.exceptions;

public class TooManyPlayersException extends IllegalArgumentException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public String getMessage() {
		return "Too many players";
	}

}
