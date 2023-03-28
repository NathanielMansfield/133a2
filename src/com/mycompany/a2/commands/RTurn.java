package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class RTurn extends Command{

	private GameWorld gw;
	
	public RTurn(GameWorld gw) {
		super("right turn");
		this.gw = gw;
		// TODO Auto-generated constructor stub
	}
	
	 public void actionPerformed(ActionEvent e)
	    {
		 	gw.right();
			System.out.println("steering right");
	    }

}
