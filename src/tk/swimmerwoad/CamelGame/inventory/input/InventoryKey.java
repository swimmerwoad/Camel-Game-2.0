package tk.swimmerwoad.CamelGame.inventory.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import tk.swimmerwoad.CamelGame.Game;
import tk.swimmerwoad.CamelGame.Game.State;

public class InventoryKey implements KeyListener{
	
	private boolean[] keys = new boolean[120];
	public boolean close;

	public void update() {
		close = keys[KeyEvent.VK_R];
		if(close){
			Game.state = State.Game;
		}
		
	}

	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	public void keyTyped(KeyEvent e) {
		
	}

}
