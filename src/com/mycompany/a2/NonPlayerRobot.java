package com.mycompany.a2;

public class NonPlayerRobot extends Robot implements IStrategy {

	private String strat;

	public NonPlayerRobot(double x, double y, int steeringDir, int maxSpeed, String strat) {
		super(x, y, steeringDir, maxSpeed);
		this.strat = strat;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setStrategy(String strat) {
	this.strat = strat;
		// TODO Auto-generated method stub

	}

	@Override
	public String getStrategy() {
		return strat;
	}

	public void switchStrategy() {
		if (strat.equals("attack")) {
			setStrategy("defend");
		} else
			setStrategy("attack");;
		
		setBase(getBase() + 1);
	}

}
