/*
 * File: StoneMasonKarel.java
 * --------------------------
 * The StoneMasonKarel subclass as it appears here does nothing.
 * When you finish writing it, it should solve the "repair the quad"
 * problem from Assignment 1.  In addition to editing the program,
 * you should be sure to edit this comment so that it no longer
 * indicates that the program does nothing.
 */

import stanford.karel.*;

public class BallotKarel extends SuperKarel {

	public void run() {
		while(frontIsClear()) {
			move();
			if(noBeepersPresent()) {
				cleanBallot();
			}
			move();
		}
	}
	
	//Cleans the ballot
	private void cleanBallot() {
		turnRight();
		checkForChads();
		checkForChads();
		turnLeft();
	}
	
	//Pre-Condition: Karel is sitting in the middle, facing either the top or bottom hole punch.
	//Post-Condition: Karel is back in the middle, facing the other hole punch location.
	private void checkForChads() {
		move();
		while(beepersPresent()) {
			pickBeeper();
		}
		turnAround();
		move();
	}
	
}
