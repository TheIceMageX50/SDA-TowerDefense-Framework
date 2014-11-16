package command;
import player.Player;
import towers.Tower;

public class PlayerHealCommand implements Command
{
	private Player player;
	private Tower tower;
	private int before;
	
	public PlayerHealCommand(Player player)
	{
		this.player = player;
		tower = player.getTower();
	}
	
	public void execute()
	{
		before = tower.getHP();
		player.healTower();
	}
	
	public void undo()
	{
		tower.setHP(before);
	}
}