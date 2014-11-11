package towers;

import minions.Minion;

public class BaseTower implements Tower
{
	
	public BaseTower()
	{
		//ctor
	}
	
	public Minion spawnMinion() 
	{
		//spawn default minion
		return new Minion(5, 10, 2);
	}
}
