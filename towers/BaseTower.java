package towers;

import minions.Minion;

public class BaseTower implements Tower
{
	private int currentHP;
	private final int maxHP = 100;
	
	public BaseTower()
	{
		currentHP = maxHP;
	}
	
	public Minion spawnMinion() 
	{
		//spawn default minion
		return new Minion(5, 10, 2);
	}

	public int getCurrentHP() {
		return currentHP;
	}

	public void setCurrentHP(int currentHP) {
		this.currentHP = currentHP;
	}

	@Override
	public void setHP(int hp) {
		currentHP = hp;
	}

	@Override
	public int getHP() {
		return currentHP;
	}
	
	@Override
	public int getMaxHP()
	{
		return maxHP;
	}
}
