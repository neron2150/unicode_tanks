package video;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import Game.App;
import Game.Information;
import Game.Map;

public class Window extends JFrame{
	private JTextArea label= new JTextArea();
	public Window(){
		super("My First Window"); 
	    
	    setVisible(true);
	    add(label);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    label.setText("");
	    label.setFont(new Font("Consolas",Font.PLAIN,16));
	    //label.enable(false);
	    label.setEditable(false);
	    addKeyListener(new KeyAdapter(){
			@Override
			public void keyPressed(KeyEvent evt){
				switch(evt.getKeyCode()){
				case KeyEvent.VK_W:		App.tank1.turnUp(); break;
				case KeyEvent.VK_A:		App.tank1.turnLeft(); break;
				case KeyEvent.VK_D:		App.tank1.turnRight(); break;
				case KeyEvent.VK_S:		App.tank1.turnDown(); break;
				case KeyEvent.VK_SPACE:	App.tank1.shoot(); break;
				
				case KeyEvent.VK_UP:		App.tank2.turnUp(); break;
				case KeyEvent.VK_LEFT:		App.tank2.turnLeft(); break;
				case KeyEvent.VK_RIGHT:		App.tank2.turnRight(); break;
				case KeyEvent.VK_DOWN:		App.tank2.turnDown(); break;
				case KeyEvent.VK_ENTER:		App.tank2.shoot(); break;
		
				}
			}
		});
	    
	  
	}
	public void update(){
		 this.requestFocus();
		String str= "",line = "\n";
		
		char [][] picture = Painter.getPicture();
	    for(int i = 0;i<picture[0].length;i++){
			for(int j = 0;j<picture.length;j++){
				str+=picture[j][i];
			}
			str+=line;
		}
	    String score = "Игрок 1:\t"+App.a+line+"Игрок 2:\t"+App.b;
	    label.setText(str+score);
	    pack();
	   
	    setLocationRelativeTo(null);
	}
}
