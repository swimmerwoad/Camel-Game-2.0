package tk.swimmerwoad.CamelGame.inventory;

public class Gold extends Item {
	
	public static int amount = 0;
	public static int sLocationX;
	public static int sLocationY;
	public static int oLocationX;
	public static int oLocationY;
	public static int slot;
	public static int width = 20;
	public static int height = 20;
	
	public Gold(){
		
	}
	
	public void update(){
		if(Gold.amount >= 1){
			if(!Inventory.slot1 || slot == 1){
				sLocationX = 20;
				sLocationY = 60;
				oLocationX = 20;
				oLocationY = 20;
				Inventory.slot1 = true;
				Gold.slot = 1;
			}
			else if(!Inventory.slot2 || slot == 2){
				sLocationX = 20;
				sLocationY = 120;
				oLocationX = 25;
				oLocationY = 85;
				Inventory.slot1 = true;
				Gold.slot = 2;
			}
		}
	}
}
