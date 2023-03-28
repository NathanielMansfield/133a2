/*
 * Abstract class for GameObjects that are allowed to move.
 * Includes methods and variables to manage object's movement
 */
package com.mycompany.a2;

public abstract class Movable extends GameObject{

	private int heading;
	private int speed;
	
	public Movable(int size,double x, double y) {
		super(size,x,y);
	}

	//updates the x and y values of the object based on it's heading and speed
	public void move() {
	
		setX(getX()+ Math.cos(Math.toRadians(90-heading))*speed);
		setY(getY()+ Math.sin(Math.toRadians(90-heading))*speed);
		
		
	}
	

	//getters and setters
	public int getHeading() {	return heading;}

	public int getSpeed() {	return speed;}
	
	public void setHeading(int heading) {this.heading = heading;}
	
	public void setSpeed(int speed) {this.speed = speed;}
	
}
