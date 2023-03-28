package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class CollideES extends Command{

	private GameWorld gw;
	
	public CollideES(GameWorld gw) {
		super("collide with energy station");
		this.gw = gw;
		// TODO Auto-generated constructor stub
	}
	
	 public void actionPerformed(ActionEvent e)
	    {
			gw.eCollide();
			System.out.println("simulating energy station collision");
	    }

}
