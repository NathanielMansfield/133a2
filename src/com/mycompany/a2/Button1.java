package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.plaf.Border;

public class Button1 extends Button {

	public Button1(Command cmd) {
		super(cmd);
		format();
	}
	
	public Button1(String str) {
		super(str);
		format();
	}
	
	private void format() {
		this.getStyle().setBgTransparency(255);
		this.getStyle().setBgColor(ColorUtil.BLUE);
		this.getStyle().setFgColor(ColorUtil.WHITE);
		this.getStyle().setBorder(Border.createLineBorder(3, ColorUtil.BLACK));
		this.getAllStyles().setPadding(Component.TOP, 1);
		this.getAllStyles().setPadding(Component.BOTTOM, 1);
	}
}