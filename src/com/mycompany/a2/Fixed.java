/*
 * Abstract class for GameObjects that are not allowed to move
 */
package com.mycompany.a2;

public abstract class Fixed extends GameObject{

	public Fixed(int size, double x, double y) {
		super(size,x,y);
	}
	
	/*
	 * Override for setting X & Y, as Fixed GameObjects are not allowed to move.
	 */
	@Override
	public void setX(double x) {	}
	
	@Override
	public void setY(double y) {	}
}
