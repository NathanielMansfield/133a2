package com.mycompany.a2;

import java.util.Observable;
import java.util.Observer;

import com.codename1.ui.Container;
import com.codename1.ui.Label;

public class ScoreView extends Container implements Observer {

private Label time;
private Label livesLeft;
private Label lastBase;
private Label energyLevel;
private Label damageLevel;
private Label Sound;
	
	public ScoreView() {
		time = new Label("time: ");
		livesLeft = new Label("lives left: ");
		lastBase = new Label("Player last base reached: ");
		energyLevel = new Label("Player energy level: ");
		damageLevel = new Label("Player damage level: ");
		
		
		
		add(time);
		add(livesLeft);
		add(lastBase);
		add(energyLevel);
		add(damageLevel);
		
	}

	public void update(Observable o, Object arg) {
		GameWorld gw = (GameWorld)arg;
		time.setText("dwdwd"+gw.getTime());
		repaint();
// code here to update labels from the game/player-robot state data
		
	}
}