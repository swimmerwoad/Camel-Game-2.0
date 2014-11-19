package tk.swimmerwoad.CamelGame.entity.mob;

import java.awt.Graphics;

import tk.swimmerwoad.CamelGame.Game;
import tk.swimmerwoad.CamelGame.dialogue.BarGuyTalk;
import tk.swimmerwoad.CamelGame.dialogue.HouseManagerTalk;
import tk.swimmerwoad.CamelGame.entity.Entity;
import tk.swimmerwoad.CamelGame.graphics.Screen;
import tk.swimmerwoad.CamelGame.graphics.Sprite;
import tk.swimmerwoad.CamelGame.level.Level;
import tk.swimmerwoad.CamelGame.quest.Quest;
import tk.swimmerwoad.CamelGame.quest.TutQuest;

public abstract class Mob extends Entity {
	
	protected Sprite sprite;
	protected int dir = 2; //0 = North/Up, 3 = West/Left
	public static boolean walking = false;
	public int fTx = 0; //First Town Location from Spawn
	public int fTy = 14; //First Town Location from Spawn
	public int sx = 63; //Spawn Location from First Town
	public int sy = 14; //Spawn Location from First Town
	public int fTTx = 33; //First Town Tavern
	public int fTTy = 12; //First Town Tavern
	public int fTHx = 6; //First Town Location From Houses
	public int fTHy = 14; //First Town Location From Houses
	public int fTCx = 53; //First Town Casino
	public int fTCy = 12; //First Town Casino
	public int fTPx = 43; //First Town Player-Owned Housing
	public int fTPy = 12; //First Town Player-Owned Housing
	
	private double xt;
	private double yt;
	private boolean solid = false;
	
	public Mob(){
		
	}
	
	public void move(int xa, int ya){
			if(xa > 0) dir = 1;
			if(xa < 0) dir = 3;
			if(ya > 0) dir = 2;
			if(ya < 0) dir = 0;
			if(!collison(xa, 0)){
				x += xa;
			}
			
			if(!collison(0, ya)){
				y += ya;
			}
	}
	
	protected boolean collison(int xa, int ya){
		solid = false;
		for (int c = 0; c  < 4; c++){
			xt = ((x + xa) + c % 2 * 20 - 10) / 16;
			yt = ((y + ya) + c / 2 * 20 - 10) / 16;
			if(xt >= fTx && xt < (fTx + 0.5) && Game.level == Level.Start){
				if(yt >= fTy && yt < (fTy + 0.5) && Game.level == Level.Start){
					x = 992;
					y = 224;
					level = Level.FirstTown;
					Game.level = Level.FirstTown;
				}
			}
			else if(xt >= sx && xt < (sx + 0.5) && Game.level == Level.FirstTown){
				if(yt >= sy && yt < (sy + 2.5) && Game.level == Level.FirstTown){
					x = 32;
					y = 224;
					level = Level.Start;
					Game.level = Level.Start;
				}
			}
			else if(xt >= fTHx && xt < (fTHx + 2.5) && Game.level == Level.FTTavern){
				if(yt >= fTHy && yt < (fTHy + 0.5) && Game.level == Level.FTTavern){
					x = fTTx * 16;
					y = (fTTy + 2) * 16;
					level = Level.FirstTown;
					Game.level = Level.FirstTown;
				}
				
			}
			else if(xt >= fTHx && xt < (fTHx + 2.5) && Game.level == Level.FTCasino){
				if(yt >= fTHy && yt < (fTHy + 0.5) && Game.level == Level.FTCasino){
					x = (fTCx) * 16;
					y = (fTCy + 2) * 16;
					level = Level.FirstTown;
					Game.level = Level.FirstTown;
				}
				
			}
			else if(xt >= fTHx && xt < (fTHx + 2.5) && Game.level == Level.FTHouse){
				if(yt >= fTHy && yt < (fTHy + 0.5) && Game.level == Level.FTHouse){
					x = (fTPx) * 16;
					y = (fTPy + 2) * 16;
					level = Level.FirstTown;
					Game.level = Level.FirstTown;
				}
				
			}
			if(xt >= fTTx && xt < (fTTx + 2.5) && Game.level == Level.FirstTown){
				if(yt >= fTTy && yt < (fTTy + 0.5) && Game.level == Level.FirstTown){
					x = 32;
					y = 32;
					level = Level.FTTavern;
					Game.level = Level.FTTavern;
				}
			}
			if(xt >= fTCx && xt < (fTCx + 2.5) && Game.level == Level.FirstTown){
				if(yt >= fTCy && yt < (fTCy + 0.5) && Game.level == Level.FirstTown){
					x = 32;
					y = 32;
					level = Level.FTCasino;
					Game.level = Level.FTCasino;
				}
			}
			if(xt >= fTPx && xt < (fTPx + 2.5) && Game.level == Level.FirstTown){
				if(yt >= fTPy && yt < (fTPy + 0.5) && Game.level == Level.FirstTown){
					x = 32;
					y = 32;
					level = Level.FTHouse;
					Game.level = Level.FTHouse;
				}
			}
			if (level.getTile((int)xt, (int)yt).solid()) solid = true;
			collision();
		}
		return solid;
	}
	
	public void render(Screen screen, Graphics g){
		
	}
	
	protected void shoot(int x, int y, double dir){
		
	}
	
	public void collision(){
		if(!Skeleton.dead){
			if(Game.level == Level.Start || Game.level == Level.TutLevel){
				if(xt < Skeleton.getX() + 1 && xt >= Skeleton.getX() - 1){
					if(yt < Skeleton.getY() + 1 && yt >= Skeleton.getY() - 1){
						solid = true;
						Skeleton.dead = true;
						Player.BashStat++;
						if(TutQuest.questPhase2){
							TutQuest.quest2();
						}
					}
				}
			}
		}
		if(Game.level == Level.Start){
			if(xt < TutorialQuestGuy.getX() + 1 && xt >= TutorialQuestGuy.getX() - 1){
				if(yt < TutorialQuestGuy.getY() + 1 && yt >= TutorialQuestGuy.getY() - 1){
					solid = true;
					if(!TutQuest.questDone && !Quest.questInit){
						TutQuest.questStart();
					}
				}
			}
		}
		if(Game.level == Level.Start || Game.level == Level.TutLevel){
			if(xt < TutorialQuestGuy.getX() + 1 && xt >= TutorialQuestGuy.getX() - 1){
				if(yt < TutorialQuestGuy.getY() + 1 && yt >= TutorialQuestGuy.getY() - 1){
					solid = true;
				}
			}
		}
		if(Game.level == Level.FTTavern){
			if(xt < BarGuy.getX() + 1 && xt >= BarGuy.getX() - 1){
				if(yt < BarGuy.getY() + 1 && yt >= BarGuy.getY() - 1){
					solid = true;
					BarGuyTalk.buyDrink();
				}
			}
		}
		if(Game.level == Level.FirstTown){
			if(xt < HouseManager.getX() + 1 && xt >= HouseManager.getX() - 1){
				if(yt < HouseManager.getY() + 1 && yt >= HouseManager.getY() - 1){
					solid = true;
					if(HouseManagerTalk.managed){
						HouseManagerTalk.buy();
					}
					else {
						HouseManagerTalk.StartManaging();
					}
				}
			}
		}
	}
}
