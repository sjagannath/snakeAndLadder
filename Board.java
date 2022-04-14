package com.game.sal;

import java.util.HashMap;

public class Board {

	private final int END = 100;

	private abstract class Obstacle {
		int mEndsAtPosition;

		protected abstract String getMessage();
	}

	private class Snake extends Obstacle {
		public Snake(int startsAtPosition, int endsAtPosition) {
			if (endsAtPosition >= startsAtPosition)
				throw new IllegalArgumentException("Snake must cause player to go to a lower position");
			mEndsAtPosition = endsAtPosition;
		}

		@Override
		protected String getMessage() {
			return "Yikes! A snake bit ya! Go back to " + mEndsAtPosition;
		}
	}

	private class Ladder extends Obstacle {
		public Ladder(int startsAtPosition, int endsAtPosition) {
			if (endsAtPosition <= startsAtPosition)
				throw new IllegalArgumentException("Ladder must cause player to go to a higher position");
			mEndsAtPosition = endsAtPosition;
		}

		@Override
		protected String getMessage() {
			return "Woohoo! A ladder! Climb up to " + mEndsAtPosition;
		}
	}

	private HashMap<Integer, Obstacle> mObstacles = new HashMap<>();

	public Board() {
		initialize();
	}

	private void initialize() {
		// Ladders
		mObstacles.put(2, new Ladder(2, 23));
		mObstacles.put(8, new Ladder(8, 12));
		mObstacles.put(17, new Ladder(17, 93));
		mObstacles.put(29, new Ladder(29, 54));
		mObstacles.put(32, new Ladder(32, 51));
		mObstacles.put(39, new Ladder(39, 80));
		mObstacles.put(62, new Ladder(62, 78));
		mObstacles.put(70, new Ladder(70, 89));
		mObstacles.put(75, new Ladder(75, 96));

		// Snakes
		mObstacles.put(41, new Snake(41, 20));
		mObstacles.put(31, new Snake(31, 14));
		mObstacles.put(59, new Snake(59, 37));
		mObstacles.put(67, new Snake(67, 50));
		mObstacles.put(92, new Snake(92, 76));
		mObstacles.put(83, new Snake(83, 80));
		mObstacles.put(99, new Snake(99, 4));
	}

	public int getFinalPosition() {
		return END;
	}

	public int playTurn(int current, int diceRoll) {
		int tempPos = (current + diceRoll) > END ? END : (current + diceRoll);
		if (mObstacles.containsKey(tempPos)) {
			Obstacle obstacle = mObstacles.get(tempPos);
			tempPos = obstacle.mEndsAtPosition;
			System.out.println(obstacle.getMessage());
		}
		return tempPos;
	}
}
