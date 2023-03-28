/*
 * Game is a singleton class that controls the game logic.
 * It creates a single game world object and calls methods to it in response
 * the the user's input.
 */
package com.mycompany.a2;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.Border;
import com.mycompany.a2.commands.Accelerate;
import com.mycompany.a2.commands.*;
import com.mycompany.a2.commands.ChangeStrat;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Label; 
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent; 
import java.lang.String; 


public class Game extends com.codename1.ui.Form{

	private GameWorld gw;
	private ScoreView sv;
	private MapView mv;
	private Toolbar tb;
	
	
	private Accelerate acc = new Accelerate(gw);
	private Brake brake = new Brake(gw);
	private ChangeStrat cStrat = new ChangeStrat(gw);
	private CollideD droneCollide = new CollideD(gw);
	private CollideES energyStationCollide = new CollideES(gw);
	private CollideNPR nprCollide = new CollideNPR(gw);
	private InformationAbout about = new InformationAbout();
	private InformationHelp help = new InformationHelp();
	private LTurn left = new LTurn(gw);
	private RTurn right = new RTurn(gw);
	private Tick tick = new Tick(gw);
	private ToggleSound tSound = new ToggleSound();
	
	
	public Game() {
		gw = new GameWorld();
		sv = new ScoreView();
		mv = new MapView();

		
		
		gw.addObserver(sv);
		gw.addObserver(mv);
		
		setLayout(new BorderLayout());
		
		add(BorderLayout.NORTH,sv);
		add(BorderLayout.CENTER,mv);
		
		mv.getAllStyles().setBorder(Border.createLineBorder(4,
				ColorUtil.BLUE));
		
		
		Container westContainer = new Container((new BoxLayout(BoxLayout.Y_AXIS)));
		add(BorderLayout.WEST,westContainer);
		
		Button1 test = new Button1("West");
		westContainer.add(test);
		
		Container southContainer = new Container((new BoxLayout(BoxLayout.X_AXIS)));
		add(BorderLayout.SOUTH,southContainer);		
		Button1 test2 = new Button1("South");
		southContainer.add(test2);
		
		Container eastContainer = new Container((new BoxLayout(BoxLayout.Y_AXIS)));
		add(BorderLayout.EAST,eastContainer);		
		Button1 test3 = new Button1("East");
		eastContainer.add(test3);
		
		addKeyListener('a', acc);
		addKeyListener('b', brake);
		addKeyListener('l', left);
		addKeyListener('r', right);
		addKeyListener('e', energyStationCollide);
		addKeyListener('g', droneCollide);
		addKeyListener('t', tick);
		
		Button1 accButton = new Button1(acc);
		Button1 brakeButton = new Button1(brake);
		Button1 leftButton = new Button1(left);
		Button1 rightButton = new Button1(right);
		Button1 dCollideButton = new Button1(droneCollide);
		Button1 esCollideButton = new Button1(energyStationCollide);
		Button1 nprCollideButton = new Button1(nprCollide);
		Button1 tickButton = new Button1(tick);
		
		accButton.addActionListener(acc);
		accButton.setCommand(acc);
		
		westContainer.add(leftButton);
		westContainer.add(accButton);
		
		eastContainer.add(rightButton);
		eastContainer.add(brakeButton);
		
		southContainer.add(dCollideButton);
		southContainer.add(esCollideButton);
		southContainer.add(nprCollideButton);
		southContainer.add(tickButton);
		
		tb = new Toolbar();
		setToolbar(tb);
		tb.setTitle("Robo Track Game");
		tb.addCommandToSideMenu(acc);
		tb.addCommandToRightBar(acc);
		
		gw.init();
		this.show();
		
		//play();
	}
	// The method that is called to control the game logic. Sets up the display then listens
	// for player input.
	private void play() 
	{ 
		Label myLabel=new Label("Enter a Command:"); 
		this.addComponent(myLabel); 
		final TextField myTextField=new TextField(); 
		this.addComponent(myTextField); 
		this.show(); 
	 
		myTextField.addActionListener(new ActionListener(){ 
	 
			public void actionPerformed(ActionEvent evt) { 
	     
				String sCommand=myTextField.getText().toString(); 
				
				if(sCommand.length() == 0) return;
				
				myTextField.clear(); 
				switch (sCommand.charAt(0)) { 
					case 'x': 
						gw.exit();  
						System.out.println("Would you like to exit? [y/n]");
						break; 
					case 'a': 
						gw.accelerate();  
						System.out.println("accelerating");
						break; 
					case 'b': 
						gw.brake();
						System.out.println("breaking");
						break; 
					case 'l': 
						gw.left();
						System.out.println("steering left");
						break; 
					case 'r': 
						gw.right();
						System.out.println("steering right");
						break; 
					case 'c': 
						gw.rCollide();
						System.out.println("simulating robot collision");
						break; 
					case 'e': 
						gw.eCollide();
						System.out.println("simulating energy station collision");
						break; 
					case 'g': 
						gw.dCollide();
						System.out.println("simulating drone collision");
						break; 
					case 't': 
						gw.tick();
						System.out.println("advancing game world one tick");
						break; 
					case 'd': 
						gw.display();  
						break; 
					case 'm': 
						gw.map();
						break;
					case 'y':
						gw.exitYes();
					case 'n':
						gw.exitNo();
					default: 
					//as the base collision isn't just checking for a character, it is  in the default case.	
						if(Character.isDigit(sCommand.charAt(0))) {
							System.out.println("Simulating base collision");
							int baseNum = Integer.parseInt(String.valueOf(sCommand.charAt(0)));
							gw.bCollide(baseNum);
						}
						
						break; 
						//add code to handle rest of the commands  
				} //switch 
			} //actionPerformed 
		} //new ActionListener() 
		); //addActionListener 
	} //play 
	
}
