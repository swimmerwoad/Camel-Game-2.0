package tk.swimmerwoad.CamelGame.graphics;

public class Sprite {
	
	public final int SIZE;
	private int x, y;
	public int[] pixels;
	private SpriteSheet sheet;
	
	public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.tiles);
	public static Sprite flower = new Sprite(16, 1, 0, SpriteSheet.tiles);
	public static Sprite grassRock = new Sprite(16, 2, 0, SpriteSheet.tiles);
	public static Sprite voidSprite = new Sprite(16, 0);
	public static Sprite stoneSprite = new Sprite(16, 0, 1, SpriteSheet.tiles);
	public static Sprite waterSprite = new Sprite(16, 0, 2, SpriteSheet.tiles);
	public static Sprite wallFront = new Sprite(16, 1, 1, SpriteSheet.tiles);
	public static Sprite spawnRoof = new Sprite(16, 2, 1, SpriteSheet.tiles);
	public static Sprite spawnFloor = new Sprite(16, 1, 2, SpriteSheet.tiles);
	
	public static Sprite table = new Sprite(16, 0, 3, SpriteSheet.tiles);
	
	public static Sprite playerFront = new Sprite(32, 0, 0, SpriteSheet.entity);
	public static Sprite playerBack = new Sprite(32, 1, 0, SpriteSheet.entity);
	public static Sprite playerSide = new Sprite(32, 1, 1, SpriteSheet.entity);
	
	public static Sprite playerFrontA = new Sprite(32, 0, 2, SpriteSheet.entity);
	public static Sprite playerBackA = new Sprite(32, 1, 2, SpriteSheet.entity);
	public static Sprite playerSideA = new Sprite(32, 1, 3, SpriteSheet.entity);
	public static Sprite SlimeWater = new Sprite(16, 0, 0, SpriteSheet.projectiles);
	
	public static Sprite skeleton = new Sprite(32, 0, 4, SpriteSheet.entity);
	public static Sprite tutQuestGuy = new Sprite(32, 1, 4, SpriteSheet.entity);
	public static Sprite pet = new Sprite(32, 0, 5, SpriteSheet.entity);
	public static Sprite barGuy = new Sprite(32, 1, 5, SpriteSheet.entity);
	
	public Sprite(int size, int x, int y, SpriteSheet sheet){
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		this.x = x * size;
		this.y = y * size;
		this.sheet = sheet;
		load();
	}
	
	public Sprite(int size, int color){
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		setColor(color);
	}
	
	public void setColor(int color){
		for(int i = 0; i < SIZE*SIZE; i++){
			pixels[i] = color;
		}
	}
	
	private void load(){
		for(int y = 0; y < SIZE; y++){
			for(int x = 0; x < SIZE; x++){
				pixels[x + y * SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE];
			}
		}
	}
}
