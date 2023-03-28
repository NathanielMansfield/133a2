/*
 * GameObject is an abstract class that defines the base
 * behavior of all the objects in the GameWorld.
 * It's children are Fixed and Movable.
 */
package com.mycompany.a2;
import com.codename1.charts.util.ColorUtil;

public abstract class GameObject {

	private int size;	
	private double x;
	private double y;
	private int color;
	
	//getters and setters
	public int getSize() {	return size; }
	
	public double getX() { return Math.round(x); }
	
	public double getY() { return Math.round(y); }
	
	public void setX(double x) { this.x = x; }
	
	public void setY(double y) { this.y = y; }

	public int getColor() { return color; }
	
	public void setColor(int color) { this.color = color; }
	
	public int getRed() { return ColorUtil.red(color); }
	
	public int getBlue() { return ColorUtil.blue(color); }
	
	public int getGreen() { return ColorUtil.green(color); }
	
	public GameObject(int size, double x, double y) {
		this.size = size;
		this.x = x;
		this.y = y;
	}
}
