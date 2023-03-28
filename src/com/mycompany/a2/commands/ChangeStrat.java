package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class ChangeStrat extends Command{

	private GameWorld gw;
	
	public ChangeStrat(GameWorld gw) {
		super("change strategy");
		this.gw = gw;
		// TODO Auto-generated constructor stub
	}
	
	 public void actionPerformed(ActionEvent e)
	    {
	    }

}
