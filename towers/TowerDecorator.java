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
	
	@Override
	public void setHP(int hp)
	{
		towerToBeDecorated.setHP(hp);
	}
	
	@Override
	public int getHP()
	{
		return towerToBeDecorated.getHP();
	}
	
	@Override
	public int getMaxHP()
	{
		return towerToBeDecorated.getMaxHP();
	}
}
