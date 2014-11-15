package player;
import towers.Tower;

public class PlayerHealCommand implements Command
{
	Tower tower;
	private int before=0;
	
	public PlayerHealCommand(Tower tower)
	{
		this.tower = tower;
	}
	
	public void execute()
	{
		before = tower.getHP();
		tower.setHP(tower.getMaxHP());
		System.out.println("Tower healed!");
	}
	
	public void undo()
	{
		tower.setHP(before);
	}
}