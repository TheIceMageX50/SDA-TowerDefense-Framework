package player;
public class Player {
	protected int CurrentHP, MaxHP, points;
	public Player()
	{
		setCurrentHP(100);
		setMaxHP(100);
		setPoints(100);		
	}
	public int getCurrentHP()
	{
		return CurrentHP;
	}
	public void setCurrentHP(int val)
	{
		CurrentHP = val;
	}
	public int getMaxHP()
	{
		return MaxHP;
	}
	public void setMaxHP(int val)
	{
		MaxHP = val;
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