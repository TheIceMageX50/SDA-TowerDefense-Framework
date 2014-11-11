package minions;

import misc.StatChange;

public class Minion 
{
	private int attack, health, speed;
	
	public Minion(int attack, int health, int speed)
	{
		this.attack = attack;
		this.health = health;
		this.speed = speed;
	}
	
	public void applyStatChanges(StatChange... changes) //accept 1 or more StatChanges
	{
		for (int i = 0; i < changes.length; i++) {
			applyStatChange(changes[i]);
		}
	}

	private void applyStatChange(StatChange change)
	{
		switch (change) {
		case ATK_BOOST : attack += 2;
		break;
		case HP_BOOST : health += 5;
		break;
		case SPEED_BOOST : speed += 2;
		}
	}

	public int getAttack()
	{
		return attack;
	}

	public void setAttack(int attack)
	{
		this.attack = attack;
	}
}
