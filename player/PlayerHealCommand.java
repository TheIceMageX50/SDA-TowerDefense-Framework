public class PlayerHealCommand implements Command
{
	Player player;
	private int before=0;
	public void execute()
	{
		before = player.getCurrentHP();
		player.setCurrentHP(player.getMaxHP());
	}
	public void undo()
	{
		player.setCurrentHP(before);
	}
}