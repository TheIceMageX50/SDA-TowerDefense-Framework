package player;

import towers.Tower;

public class Player {
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

	public int getPoint()
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
}