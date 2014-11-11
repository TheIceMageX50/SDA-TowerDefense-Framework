package towers;

import minions.Minion;

public abstract class TowerDecorator implements Tower
{
	protected Tower towerToBeDecorated;
	
	public TowerDecorator(Tower towerToDecorate)
	{
		towerToBeDecorated = towerToDecorate;
	}
	
	public Minion spawnMinion()
	{
		return towerToBeDecorated.spawnMinion();
	}
}
