package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class CollideD extends Command{

	private GameWorld gw;
	
	public CollideD(GameWorld gw) {
		super("collide with drone");
		this.gw = gw;
		// TODO Auto-generated constructor stub
	}
	
	 public void actionPerformed(ActionEvent e)
	    {
			gw.dCollide();
			System.out.println("simulating drone collision");
	    }

}
