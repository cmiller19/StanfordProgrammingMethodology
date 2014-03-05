/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {

	public void run() {
		evenSpace();
	}

	//Pre-Condition: Karel is standing on an even space.
	//Post-Condition: If he can move, Karel is standing on the next position and has called oddSpace();
	private void evenSpace() {
		putBeeper();
		if (frontIsClear()) {
			move();
			oddSpace();
		}
		else 
		{
			turnUp();
			if(frontIsClear()) {
				move();
				turnTowardsMiddle();
				oddSpace();
			}
		}
	}
	
	//Pre-Condition: Karel is standing on an odd space.
	//Post-Condition: If he can move, Karel is standing on the next position and has called evenSpace();
	private void oddSpace() {
		if(frontIsClear()) {
			move();
			evenSpace();
		}
		else 
		{
			turnUp();
			if(frontIsClear()) {
				move();
				turnTowardsMiddle();
				evenSpace();
			}
		}
	}
	
	//Pre-Condition: Karel is at a wall.
	//Post-Condition: Karel is now facing north.
	private void turnUp() {
		if(facingEast()) {
			turnLeft();
		}
		else 
		{
			turnRight();
		}
	}
	
	//Pre-Condition:  Karel is facing North.
	//Post-Condition: Karel is facing the middle of the board.
	private void turnTowardsMiddle() {
		if(leftIsClear()) {
			turnLeft();
		}
		else
		{
			turnRight();
		}
	}
}
