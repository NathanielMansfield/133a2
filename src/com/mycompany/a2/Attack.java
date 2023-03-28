package com.mycompany.a2;

public class Attack implements IStrategy {

	private NonPlayerRobot npr;
	
	public Attack(NonPlayerRobot npr, Robot pc) {
		this.npr = npr;
	}
	
	@Override
	public void apply() {
		
	}

}
