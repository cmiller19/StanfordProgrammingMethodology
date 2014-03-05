/*
 * File: MidpointFindingKarel.java
 * -------------------------------
 * When you finish writing it, the MidpointFindingKarel class should
 * leave a beeper on the corner closest to the center of 1st Street
 * (or either of the two central corners if 1st Street has an even
 * number of corners).  Karel can put down additional beepers as it
 * looks for the midpoint, but must pick them up again before it
 * stops.  The world may be of any size, but you are allowed to
 * assume that it is at least as tall as it is wide.
 */

import stanford.karel.*;

public class MidpointFindingKarel extends SuperKarel {

	public void run() {
		buildEndpoints();
		walkToMiddle();
		setMiddleBeeper();
	}
	
	//Pre-Condition: Karel facing East with back against wall.
	//Post-Condition: Karel facing West on endpoint beeper.
	private void buildEndpoints() {
		move();
		putBeeper();
		while(frontIsClear()) {
			move();
			putBeeper();
		}
		turnAround();
		pickBeeper();
		move();
	}
	
	//Pre-Condition: Karel standing on end point beeper.
	//Post-Condition: Karel standing one location ahead of mid-point.
	private void walkToMiddle() {
		while(beepersPresent()) {
			findEndpointBeeper();
			pickBeeper();
			move();
		}
	}
	
	//Pre-Condition: Karel standing on end point beeper. 
	//Post-Condition: Karel standing on new opposite side end point beeper.
	private void findEndpointBeeper() {
		while(beepersPresent()) {
			move();
		}
		turnAround();
		move();
	}
	
	//Pre-Condition: Karel standing one location ahead of mid-point.
	//Post-Condition: Karel standing at mid-point on beeper.
	private void setMiddleBeeper() {
		turnAround();
		move();
		putBeeper();
	}
}
