package towers;

import minions.Minion;

public interface Tower 
{
	public Minion spawnMinion();
	public void setHP(int hp);
	public int getHP();
	public int getMaxHP();
}
