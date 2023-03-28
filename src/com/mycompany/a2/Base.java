/*
 * Bases are GameObjects in the world which the player robot will need to
 * touch in sequence from first to last in order to win the game.
 */
package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;

public class Base extends Fixed {

	//constants
	private static final int initSize = 20;
	private static final int initColor = ColorUtil.rgb(150, 150, 0);
	
	
	private int sequenceNum;
	
	public Base(double x, double y, int sequenceNum) {
		super(initSize, x, y);
		setColor(initColor);
		this.sequenceNum = sequenceNum;
	}
	
	//sequenceNum getter
	public int getSequenceNum() {
		return sequenceNum;
	}
	
}
