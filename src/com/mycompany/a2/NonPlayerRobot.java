package com.mycompany.a2;

public class NonPlayerRobot extends Robot{

	//private String strat;

	private IStrategy strat;
	
	public NonPlayerRobot(double x, double y, int steeringDir, int maxSpeed, IStrategy strat) {
		super(x, y, steeringDir, maxSpeed);
		this.strat = strat;
		// TODO Auto-generated constructor stub
	}

	public void setStrategy(IStrategy strat) {
		this.strat = strat;
		// TODO Auto-generated method stub

	}

	public void invokeStrategy() {
		strat.apply();
	}
	
	public IStrategy getStrategy() {
		return strat;
	}

	public void switchStrategy(Robot pc) {
		if (strat instanceof Attack) {
			strat = new Defend(this);
		} else
			strat = new Attack(this,pc);
		
		setBase(getBase() + 1);
	}

}
