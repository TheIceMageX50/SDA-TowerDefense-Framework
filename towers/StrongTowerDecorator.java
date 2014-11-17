package towers;

import minions.Minion;
import misc.GameEngine;
import misc.StatChange;

public class StrongTowerDecorator extends TowerDecorator
{

	public StrongTowerDecorator(Tower towerToDecorate)
	{
		super(towerToDecorate);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Minion spawnMinion()
	{
		GameEngine engine = GameEngine.getInstance();
		Minion minion = super.spawnMinion();
		engine.display("[Decorator Pattern] Minion decorated with extra strength!");
		minion = boostAtk(minion);
		//^ increase minion's atk with private method here
		return minion;
	}
	
	private static Minion boostAtk(Minion minion)
	{
		minion.applyStatChanges(StatChange.ATK_BOOST);
		return minion;
	}
}
