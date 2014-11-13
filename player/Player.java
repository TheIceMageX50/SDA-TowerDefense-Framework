package player;
public class Player {
	protected int  points;
	public Player()
	{
		setPoints(1000);		
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