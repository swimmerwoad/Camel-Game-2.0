package tk.swimmerwoad.CamelGame.level.tile;

import tk.swimmerwoad.CamelGame.graphics.Screen;
import tk.swimmerwoad.CamelGame.graphics.Sprite;

public class Tile {
	
	public int x;
	public int y;
	
	public Sprite sprite;
	
	public static Tile grassTile = new GrassTile(Sprite.grass);
	public static Tile flowerTile = new FlowerTile(Sprite.flower);
	public static Tile grassRockTile = new GrassRockTile(Sprite.grassRock);
	public static Tile voidTile = new VoidTile(Sprite.voidSprite);
	public static Tile stoneTile = new StoneTile(Sprite.stoneSprite);
	public static Tile waterTile = new WaterTile(Sprite.waterSprite);
	public static Tile spawnWall = new SpawnWall(Sprite.wallFront);
	public static Tile spawnRoof = new SpawnRoof(Sprite.spawnRoof);
	public static Tile spawnFloor = new SpawnFloor(Sprite.spawnFloor);
	
	public static final int grassColor = 0xff00ff00;
	public static final int flowerColor = 0xffffff00;
	public static final int grassRockColor = 0xff7f7f00;
	public static final int waterColor = 0xff0000ff;
	public static final int stoneColor = 0xffdfdfdf;
	public static final int spawnWallColor = 0xff6f4e37;
	public static final int spawnRoofColor = 0xff38281c;
	public static final int spawnfloorColor = 0xffffffff;
	
	public Tile(Sprite sprite){
		this.sprite = sprite;
	}
	
	public void render(int x, int y, Screen screen){
		
	}
	
	public boolean solid(){
		return false;
	}
	
	public boolean boat(){
		return false;
	}
}
