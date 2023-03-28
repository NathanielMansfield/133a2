package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class Accelerate extends Command{

	private GameWorld gw;
	
	public Accelerate(GameWorld gw) {
		super("accelerate");
		this.gw = gw;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	 public void actionPerformed(ActionEvent evt)
	    {
	        gw.accelerate();
	        System.out.println("Accelerate speed");
	    }

}
