package minions;

import misc.StatChange;

public class Minion 
{
	private int attack, health, speed;
	
	public Minion(int attack, int health, int speed)
	{
		this.attack = attack;
		this.setHealth(health);
		this.setSpeed(speed);
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
		case HP_BOOST : setHealth(getHealth() + 5);
		break;
		case SPEED_BOOST : setSpeed(getSpeed() + 2);
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

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
}
