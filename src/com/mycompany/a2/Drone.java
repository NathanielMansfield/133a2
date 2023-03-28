/*
 * Drones are game objects that wander the map in random directions.
 * When they collide with the player robot, the do a small amount of damage.
 */
package com.mycompany.a2;

import java.util.Random;

import com.codename1.charts.util.ColorUtil;

public class Drone extends Movable {

	//constants
	private static final int initSize = 5;
	private static final int initColor = ColorUtil.rgb(200, 150, 43);
	
	Drone(int x, int y, int heading, int speed) {
		super(initSize, x, y);
		super.setColor(initColor);
		setSpeed(speed);
		setHeading(heading);
	}

	/*
	 * Drones change heading before moving and check if they are out of bounds.
	 */
	@Override
	public void move() {
		Random rand = new Random();

		//randomly determine a direction, then change your heading by 5 before moving
		
		if (rand.nextBoolean()) {
			setHeading(getHeading() + rand.nextInt(5));
		} else {
			setHeading(getHeading() - rand.nextInt(5));
		}
		
		
		super.move();
		
		//if moving would put drone out of bounds, turn the drone around and move it back
		
		if(getX()< 0 || getY() < 0 || getX() > 1024 || getY() > 768) {
			setHeading((getHeading() +180) % 359);
		}
		
	}
	
	/*
	 * overriding parents setColor with empty body, as Drones are not allowed to change color.
	 */
	public void setColor() {  }
}
