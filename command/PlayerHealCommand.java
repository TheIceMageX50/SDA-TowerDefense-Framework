package command;
import misc.GameEngine;
import player.Player;
import towers.Tower;

public class PlayerHealCommand implements Command
{
	private Player player;
	private Tower tower;
	private int before;
	
	public PlayerHealCommand(Player player)
	{
		GameEngine engine = GameEngine.getInstance();
		engine.display("[Command Pattern] Player heal command encapsulated as an object.");
		this.player = player;
		tower = player.getTower();
	}
	
	public void execute()
	{
		GameEngine engine = GameEngine.getInstance();
		engine.display("[Command Pattern] Executing PlayerHealCommand...");
		before = tower.getHP();
		player.healTower();
	}
	
	public void undo()
	{
		GameEngine engine = GameEngine.getInstance();
		engine.display("Undoing PlayerHealCommand...");
		tower.setHP(before);
	}
}