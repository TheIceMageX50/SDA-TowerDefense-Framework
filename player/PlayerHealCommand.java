package player;
import towers.BaseTower;
public class PlayerHealCommand implements Command
{
	BaseTower baseTower;
	private int before=0;
	public void execute()
	{
		before = baseTower.getCurrentHP();
		baseTower.setCurrentHP(MaxHP);
	}
	public void undo()
	{
		baseTower.setCurrentHP(before);
	}
}