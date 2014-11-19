package tk.swimmerwoad.CamelGame.inventory;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import tk.swimmerwoad.CamelGame.entity.mob.Player;

public class Inventory {
	
	public static Rectangle gui = new Rectangle (0, 0, 200, 900);
	public static String goldString = "Gold: " + Integer.toString(Gold.amount);
	public static String aleString = "Ale: " + Integer.toString(Ale.amount);
	
	public static String moveString = "Move Level: " + Integer.toString(Player.MoveLevel);
	public static String bashString = "Bash Level: " + Integer.toString(Player.BashLevel);
	public static String vigString = "Vigilante Level: " + Integer.toString(Player.VigLevel);
	
	public static Color Brown = new Color(139, 69, 19);
	public static boolean slot1 = false;
	public static boolean slot2 = false;
	
	public Inventory(){
		
	}
	
	public void render(Graphics g){
		Graphics2D gi = (Graphics2D) g;
		gi.setColor(Color.CYAN);
		gi.draw(gui);
		gi.fillRect(0, 0, 200, 900);
		if(Gold.amount >= 1){
			g.setColor(Color.BLACK);
			g.drawString(goldString, Gold.sLocationX, Gold.sLocationY);
			g.setColor(Color.YELLOW);
			g.fillOval(Gold.oLocationX, Gold.oLocationY, Gold.width, Gold.height);
		}
		if(Ale.amount >= 1){
			g.setColor(Color.BLACK);
			g.drawString(aleString, Ale.sLocationX, Ale.sLocationY);
			g.setColor(Color.GRAY);
			g.fillRect(Ale.oLocationX, Ale.oLocationY - 10, Ale.width1, Ale.height1);
			g.setColor(Brown);
			g.fillRect(Ale.oLocationX, Ale.oLocationY - Ale.width1, Ale.width2, Ale.height2);
			
		}
		g.setColor(Color.RED);
		g.drawString(moveString, 100, 50);
		g.drawString(bashString, 100, 65);
		g.drawString(vigString, 100, 80);
		
	}
	
	public void update(){
		goldString = "Gold: " + Integer.toString(Gold.amount);
		aleString = "Ale: " + Integer.toString(Ale.amount);
		moveString = "Move Level: " + Integer.toString(Player.MoveLevel);
		bashString = "Bash Level: " + Integer.toString(Player.BashLevel);
		vigString = "Vigilante Level: " + Integer.toString(Player.VigLevel);
	}
	
}
