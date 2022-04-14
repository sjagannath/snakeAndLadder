package com.game.sal;

import com.game.sal.Game.COLOUR;

public class Player {

	private int mCurrentPostion;
	private final String mName;
	private final COLOUR mPlayerColour;
	private final boolean mIsComputer;
	
	public Player(String name, COLOUR colour, boolean isComputer) {
		mName = (name == null || name.isEmpty())?colour.name():name;
		mPlayerColour = colour;
		mCurrentPostion = 0;
		mIsComputer = isComputer;
	}

	public String getPlayerColour() {
		return mPlayerColour.name();
	}
	public int getCurrentPostion() {
		return mCurrentPostion;
	}

	public void setCurrentPostion(int mCurrentPostion) {
		this.mCurrentPostion = mCurrentPostion;
	}

	public String getName() {
		return mName;
	}

	public boolean isComputer() {
		return mIsComputer;
	}
}
