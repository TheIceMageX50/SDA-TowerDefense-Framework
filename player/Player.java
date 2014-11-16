package player;

import maps.GameMap;
import misc.GameEngine;
import misc.TerrainType;
import towers.Tower;

public class Player
{
	private int points;
	private String name;
	private Tower tower;
	private int posX, posY; //x,y position tower is at on the map
	
	public Player(String name, Tower tower, int towX, int towY)
	{
		points = 1000;	
		this.name = name;
		this.tower = tower;
		posX = towX;
		posY = towY;
	}

	public int getPoints()
	{
		return points;
	}
	public void setPoints(int val)
	{
		points = val;
	}

	public String getName() {
		return name;
	}
	
	public Tower getTower()
	{
		return tower;
	}
	
	public void healTower()
	{
		GameEngine engine = GameEngine.getInstance();
		if (tower.getHP() < tower.getMaxHP()) {
			points -= 500;
			tower.setHP(tower.getMaxHP());
		} else {
			engine.display("Tower HP is already full! No need to heal, silly...");
		}
	}
	
	public void placeWall(int x, int y)
	{
		GameEngine engine = GameEngine.getInstance();
		GameMap theMap = engine.getMap();
		
		//Does the player have enough points?
		if (points >= 200) {
			points -= 200;
			theMap.placeWall(x, y);
		} else {
			engine.display("Insufficient points.");
		}
	}
	
	public void takeWall(int x, int y)
	{
		GameEngine engine = GameEngine.getInstance();
		GameMap theMap = engine.getMap();
		
		//Is there really a wall at this position?
		if (theMap.inspect(x, y) == TerrainType.PLACED_WALL) {
			points += 200;
			theMap.takeWall(x, y);
		} else {
			engine.display("There is no wall placed at that position!");
		}
	}
}