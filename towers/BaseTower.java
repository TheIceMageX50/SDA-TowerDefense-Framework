package towers;

import minions.Minion;

public class BaseTower implements Tower
{
	private int CurrentHP;
	private final int MaxHP = 100;
	public BaseTower()
	{
		setCurrentHP(MaxHP);
	}
	
	public Minion spawnMinion() 
	{
		//spawn default minion
		return new Minion(5, 10, 2);
	}

	public int getCurrentHP() {
		return CurrentHP;
	}

	public void setCurrentHP(int currentHP) {
		CurrentHP = currentHP;
	}
}
