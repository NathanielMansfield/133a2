/*
 * Robot object that includes the player character and enemies.
 */
package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;

public class Robot extends Movable implements ISteerable {

	//constants
	private static final int initSize = 10;
	private static final int initColor = ColorUtil.rgb(30, 150, 150);
		
	private int steeringDir = 0;
	private int maxSpeed = 30;
	private int energyLevel = 20;
	private int energyConsumptionRate = 1;
	private int damageLevel = 0;
	private int maxDamage = 10;
	private int lastBaseReached = 1;

	public Robot(double x, double y, int steeringDir, int maxSpeed) {

		super(initSize, x, y);
		this.maxSpeed = maxSpeed;
		setColor(initColor);
		this.steeringDir = steeringDir;
	}

	//sets steering of the robot while maintaining steering rules
	public void setSteering(int steer) {

		// enforces maximum steering at a time
		if (steer > 5) {
			steer = 5;
		} else if (steer < -5) {
			steer = -5;
		}
		// enforces maximum steering direction, sets new steering
		if ((getSteeringDirection() + steer) > 40) {
			steeringDir = 40;
		} else if ((getSteeringDirection() + steer) < -40) {
			steeringDir = -40;
		} else {
			steeringDir = steeringDir + steer;
		}
	}

	//sets the speed of the robot while maintaining speed rules
	public void setSpeed(int speed) {

		//enforces speed must be positive rule
		if (speed < 0) {

			super.setSpeed(0);
			
		} else if (damageLevel == 0) { 
			
			//enforces speed must be less than max when undamaged
			if(speed < maxSpeed) {
				super.setSpeed(speed);
			} else {
				super.setSpeed(maxSpeed);
			}
			
		} else {
			//enforces speed must be less than max when damaged
			int dmgMaxSpeed = maxSpeed - (damageLevel / maxDamage) * maxSpeed;

			if (speed > dmgMaxSpeed) {
				super.setSpeed(dmgMaxSpeed);
			} else {
				super.setSpeed(speed);
			}

		}
	}

	//getters and setters
	public void setEnergy(int energyLevel) { this.energyLevel = energyLevel;	}
	
	public int getEnergy() {	return energyLevel;	}
	
	public void setBase(int lastBaseReached) {	this.lastBaseReached = lastBaseReached;}
	
	public int getBase() {	return lastBaseReached;	}
	
	public void setDamage(int damage) {	this.damageLevel = damage; }
	
	public int getDamage() {	return damageLevel; }

	public int getMaxSpeed() { return maxSpeed; }
	
	public void setMaxSpeed(int maxSpeed) { this.maxSpeed = maxSpeed; }
	
	public int getSteeringDirection() { return steeringDir; }
	
	public void setSteeringDirectiond(int steeringDir) { this.steeringDir = steeringDir; }
		
	public int getMaxDamage() {	return maxDamage; }
	
	public int getEnergyConsumptionRate() { return energyConsumptionRate; }
	
	public void setEnergyConsumptionRate(int energyConsumptionRate) { this.energyConsumptionRate = energyConsumptionRate; }
}
