package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class LTurn extends Command{

	private GameWorld gw;
	
	public LTurn(GameWorld gw) {
		super("left turn");
		this.gw = gw;
		// TODO Auto-generated constructor stub
	}
	
	 public void actionPerformed(ActionEvent e)
	    {
		 	gw.left();
			System.out.println("steering left");
	    }

}
