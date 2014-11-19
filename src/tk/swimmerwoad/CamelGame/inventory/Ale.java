package tk.swimmerwoad.CamelGame.inventory;

public class Ale extends Item{
	
	public static int amount;
	public static int sLocationX;
	public static int sLocationY;
	public static int oLocationX;
	public static int oLocationY;
	public static int width1 = 20;
	public static int height1 = 30;
	public static int width2 = 20;
	public static int height2 = 10;
	public static int slot;
	
	public Ale(){
		
	}
	
	public void update(){
		if(Ale.amount >= 1){
			if(!Inventory.slot1 || slot == 1){
				sLocationX = 23;
				sLocationY = 80;
				oLocationX = 25;
				oLocationY = 40;
				Inventory.slot1 = true;
				Ale.slot = 1;
			}
			else if(!Inventory.slot2 || slot == 2){
				sLocationX = 23;
				sLocationY = 150;
				oLocationX = 25;
				oLocationY = 118;
				Inventory.slot1 = true;
				Ale.slot = 2;
			}	
		}
	}
}
