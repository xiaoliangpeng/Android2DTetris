package com.segmac.tetris.object;

import java.util.Random;

import android.graphics.Color;

public class S implements TetrisObject {

	//注意：Coordinate(列, 行)
	private final Coordinate[] stateOne = {new Coordinate(1, 0), new Coordinate(2, 0),
			new Coordinate(0, 1), new Coordinate(1, 1)};
	private final Coordinate[] stateTwo = {new Coordinate(1, 0), new Coordinate(1, 1), 
			new Coordinate(2, 1), new Coordinate(2, 2)};
	public Coordinate[] currentState = stateOne;
	public Coordinate[] prevState = stateOne;

	public S(){

	}
	
	@Override
	public void transform() {
		prevState = currentState;
		if(currentState == stateOne) currentState = stateTwo;
		else if(currentState == stateTwo) currentState = stateOne;
	}

	@Override
	public void randomState() {
		Random random = new Random();
		int i = random.nextInt(2);
		switch (i) {
		case 0:
			currentState = stateOne;
			break;
		case 1:
			currentState = stateTwo;
			break;
		default:
			break;
		}
	}

	@Override
	public Coordinate[] getNextTetrisState() {
		if(currentState == stateOne) return stateTwo;
		else if(currentState == stateTwo) return stateOne;
		return stateOne;
	}

	@Override
	public Coordinate[] getCurrentTetrisState() {
		return currentState;
	}

	@Override
	public Coordinate[] getPrevTetrisState() {
		return prevState;
	}

	@Override
	public int getTetrisColor() {
		return Color.CYAN;
	}

	@Override
	public int getRows() {
		if(currentState == stateOne) return 2;
		else if(currentState == stateTwo) return 3;
		return 0;
	}
}