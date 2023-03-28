/*
 * Energy stations are fixed GameObjects that restore the player robot's
 * energy when it collides with them based the the energy station's capacity.
 */
package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;

public class EnergyStation extends Fixed{

	private int capacity;
	
	public EnergyStation(int x, int y,int capacity){
		super(15, x, y);
		this.capacity = capacity;
		setColor(ColorUtil.rgb(70, 20, 250));
	}
	
	//getters and setters
	public int getCapacity() { return capacity; }
	
	public void setCapacity(int capacity) { this.capacity = capacity; }
}
