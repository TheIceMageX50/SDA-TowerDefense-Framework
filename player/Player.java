package player;

import towers.Tower;

public class Player {
	private int points;
	
	public Player()
	{
		points = 1000;	
	}

	public int getPoint()
	{
		return points;
	}
	public void setPoints(int val)
	{
		points = val;
	}
}