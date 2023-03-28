/*
 * GameWorld handles all the logic 
 */
package com.mycompany.a2;

import java.util.Observable;
import java.util.Random;
import java.util.Vector;

import com.codename1.charts.util.ColorUtil;
import com.codename1.io.JSONParseCallback;

public class GameWorld extends Observable {

	private int clockTime = 0;
	private int livesRemaining = 3;
	private boolean isExitState = false;
	private Robot pc;
	Vector<GameObject> theWorldVector;

	/*
	 * Initializes the GameWorld, creates all the game objects, and
	 * stores them within theWorldVector vector. Drones and energy stations
	 * are initializes to a random location within the game world.
	 */
	public void init() {

		Random rand = new Random();

		theWorldVector = new Vector<GameObject>();

		Base firstBase = new Base(20, 90, 1);

		theWorldVector.add(firstBase);
		theWorldVector.add(new Base(300, 160, 2));
		theWorldVector.add(new Base(450, 500, 3));
		theWorldVector.add(new Base(780, 320, 4));

		pc = new Robot(firstBase.getX(), firstBase.getY(), 0, 30);

		theWorldVector.add(pc);
		theWorldVector.add(new Drone(rand.nextInt(1024), rand.nextInt(768), rand.nextInt(359), rand.nextInt(5) + 5));
		theWorldVector.add(new Drone(rand.nextInt(1024), rand.nextInt(768), rand.nextInt(359), rand.nextInt(5) + 5));

		theWorldVector.add(new EnergyStation(rand.nextInt(1024), rand.nextInt(768), 20));
		theWorldVector.add(new EnergyStation(rand.nextInt(1024), rand.nextInt(768), 30));

		theWorldVector.add(new Robot(rand.nextInt(1024), rand.nextInt(768), 0, 30));
		theWorldVector.add(new Robot(rand.nextInt(1024), rand.nextInt(768), 0, 30));
		theWorldVector.add(new Robot(rand.nextInt(1024), rand.nextInt(768), 0, 30));
		
		//setChanged();
		notifyObservers();
		
	}
	/*
	 * exit command to end the game, works with exitYes()
	 * and exitNo() to confirm the users choice before exiting.
	 */
	public void exit() {
		isExitState = true;
	}
	/*
	 * increases the speed of the player robot by 5.
	 * Will not go over the player robot's max speed.
	 */
	public void accelerate() {

		pc.setSpeed(pc.getSpeed() + 5);
	}
	/*
	 * decreases the speed of the player robot by 5.
	 * Will not go below 0.
	 */
	public void brake() {
		pc.setSpeed(pc.getSpeed() - 5);
	}
	/*
	 * decreases the steering direction of the player robot by 5.
	 * Will not go below -40.
	 */
	public void left() {
		pc.setSteering(-5);
	}
	/*
	 * Increases the steering direction of the player robot by 5.
	 * Will not go above 40.
	 */
	public void right() {
		pc.setSteering(5);
	}
	/*
	 * Simulates a collision between the player and a robot.
	 * Increases player damage, updates player color, and calls
	 * playerLost if the player robot is too damaged.
	 */
	public void rCollide() {
		pc.setDamage(pc.getDamage() + 2);
		pc.setColor(ColorUtil.rgb(pc.getRed() + 20, pc.getGreen(), pc.getBlue()));
		if (pc.getDamage() >= pc.getMaxDamage()) {
			System.out.println("Robot is too damaged!");
			playerLost();
		}
	}
	/*
	 * simulates a player collision with a base with number baseNum.
	 */
	public void bCollide(int baseNum) {

		if (baseNum == pc.getBase() + 1) {
			pc.setBase(pc.getBase() + 1);
		}

	}
	/*
	 * simulates a collision with the player robot and an energy station.
	 */
	public void eCollide() {

		// grabs the first energy station in theWorldVector to collide with
		for (int i = 0; i < theWorldVector.size(); i++) {
			if (theWorldVector.elementAt(i) instanceof EnergyStation) {
				EnergyStation eStation = (EnergyStation) theWorldVector.elementAt(i);
				pc.setEnergy(eStation.getCapacity() + pc.getEnergy());
				eStation.setCapacity(0);
				eStation.setColor(ColorUtil.rgb(120,190,33));
				return;


			}
		}
	}
	/*
	 * simulates a collision with a drone, calls playerLost if the 
	 * player robot has reached maximum damage.
	 */
	public void dCollide() {
		pc.setDamage(pc.getDamage() + 1);
		pc.setColor(ColorUtil.rgb(pc.getRed() + 20, pc.getGreen(), pc.getBlue()));
		if (pc.getDamage() >= pc.getMaxDamage()) {
			System.out.println("Robot is too damaged!");
			playerLost();
		}
	}

	public void tick() {

		clockTime += 1;
		pc.setEnergy(pc.getEnergy() - pc.getEnergyConsumptionRate());
		if (pc.getDamage() >= pc.getMaxDamage() || pc.getEnergy() <= 0)
			playerLost();
		pc.setHeading(pc.getHeading() + pc.getSteeringDirection());
		
		for (int i = 0; i < theWorldVector.size(); i++) {
			if (theWorldVector.elementAt(i) instanceof Movable) {
				Movable mObj = (Movable) theWorldVector.elementAt(i);
				mObj.move();
			}
		}
		
	}

	/*
	 * Displays the current status of the game world and player robot.
	 */
	public void display() {
		System.out.println("The player has " + livesRemaining + " lives left.");
		System.out.println("The system time is: " + clockTime);
		System.out.println("The player has reached " + pc.getBase());
		System.out.println("The player robot has energy level: " + pc.getEnergy());
		System.out.println("The robot currently has " + pc.getDamage() + " damage.");
	}
	/*
	 * loops through the world vector and displays information about every object in the world.
	 */
	public void map() {
		for (int i = 0; i < theWorldVector.size(); i++) {
			if (theWorldVector.elementAt(i) instanceof Base) {
				Base bObj = (Base) theWorldVector.elementAt(i);
				System.out.println("Base: loc = " + bObj.getX() + "," + bObj.getY() + " color = [" + bObj.getRed() + ","
						+ bObj.getGreen() + "," + bObj.getBlue() + "] size = " + bObj.getSize() + " sequence number = "
						+ bObj.getSequenceNum());
			} else if (theWorldVector.elementAt(i) instanceof Robot) {
				Robot rObj = (Robot) theWorldVector.elementAt(i);
				System.out.println("Robot: loc = " + rObj.getX() + "," + rObj.getY() + " color = [" + rObj.getRed()
						+ "," + rObj.getGreen() + "," + rObj.getBlue() + "] heading = " + rObj.getHeading()
						+ " speed = " + rObj.getSpeed() + " size = " + rObj.getSize() + " maxspeed = "
						+ rObj.getMaxSpeed() + " steering direction = " + rObj.getSteeringDirection()
						+ " energy level = " + rObj.getEnergy() + " damage level = " + rObj.getDamage());
			} else if (theWorldVector.elementAt(i) instanceof Drone) {
				Drone rObj = (Drone) theWorldVector.elementAt(i);
				System.out.println("Drone: loc = " + rObj.getX() + "," + rObj.getY() + " color = [" + rObj.getRed()
						+ "," + rObj.getGreen() + "," + rObj.getBlue() + "] heading = " + rObj.getHeading()
						+ " speed = " + rObj.getSpeed() + " size = " + rObj.getSize());

			} else if (theWorldVector.elementAt(i) instanceof EnergyStation) {
				EnergyStation eObj = (EnergyStation) theWorldVector.elementAt(i);
				System.out.println("Energy Station: loc = " + eObj.getX() + "," + eObj.getY() + " color = ["
						+ eObj.getRed() + "," + eObj.getGreen() + "," + eObj.getBlue() + "] size = " + eObj.getSize()
						+ " capacity = " + eObj.getCapacity());
			}
		}
	}

	/*
	 * confirmation to exit the game after exit() is called
	 */
	public void exitYes() {
		if (isExitState)
			System.exit(0);
	}
	/*
	 * resets isExitState from calling exit()
	 */
	public void exitNo() {
		isExitState = false;
	}
	/*
	 * reduces the lives remaining when the player looses.
	 */
	private void playerLost() {
		livesRemaining -= 1;
	}
	
	public int getTime() {return clockTime;}
	public int getLives() {return livesRemaining;}
	public int getlastBaseReached() {return pc.getBase();}
	public int getEnergyLevel() {return pc.getEnergy();}
	public int getDamageLevel() {return pc.getDamage();}
	
}