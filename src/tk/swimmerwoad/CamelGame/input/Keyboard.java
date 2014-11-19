package tk.swimmerwoad.CamelGame.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import tk.swimmerwoad.CamelGame.Game;
import tk.swimmerwoad.CamelGame.Game.State;

public class Keyboard implements KeyListener{
	
	private boolean[] keys = new boolean[120];
	public boolean up;
	public boolean down;
	public boolean left;
	public boolean right;
	public boolean inv;
	public boolean menu;
	public boolean edit;

	
	@SuppressWarnings("static-access")
	public void update(){
		up = keys[KeyEvent.VK_W] || keys[KeyEvent.VK_UP];
		down = keys[KeyEvent.VK_S] || keys[KeyEvent.VK_DOWN];
		left = keys[KeyEvent.VK_A] || keys[KeyEvent.VK_LEFT];
		right = keys[KeyEvent.VK_D] || keys[KeyEvent.VK_RIGHT];
		inv = keys[KeyEvent.VK_E];
		menu = keys[KeyEvent.VK_ESCAPE];
		edit = keys[KeyEvent.VK_G];
		if(edit && Game.level == Game.level.FTHouse){
			Game.state = State.Edit;
		}
	}

	public void keyTyped(KeyEvent e) {
		
	}

	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

}
