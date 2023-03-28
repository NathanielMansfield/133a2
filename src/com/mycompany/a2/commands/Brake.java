package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class Brake extends Command{

	private GameWorld gw;
	
	public Brake(GameWorld gw) {
		super("Brake");
		this.gw = gw;
		// TODO Auto-generated constructor stub
	}
	 
	 public void actionPerformed(ActionEvent e)
	    {
		 	gw.brake();
			System.out.println("breaking");
	    }

}
