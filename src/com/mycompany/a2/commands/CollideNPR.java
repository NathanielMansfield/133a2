package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class CollideNPR extends Command{

	private GameWorld gw;
	
	public CollideNPR(GameWorld gw) {
		super("collide with npr");
		this.gw = gw;
		// TODO Auto-generated constructor stub
	}
	
	 public void actionPerformed(ActionEvent e)
	    {
		 	gw.rCollide();
			System.out.println("simulating robot collision");
	    }

}
