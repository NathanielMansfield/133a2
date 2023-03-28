package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class Tick extends Command{

	private GameWorld gw;
	
	public Tick(GameWorld gw) {
		super("tick");
		this.gw = gw;
		// TODO Auto-generated constructor stub
	}
	
	 public void actionPerformed(ActionEvent e)
	    {
		 	gw.tick();
			System.out.println("advancing game world 1 tick");
	    }

}
