package player;
import maps.GameMap;
public class PlayerPlaceTowerCommand implements Command
{
	GameMap map;
	private int xBefore;
	private int yBefore;
	public PlayerPlaceTowerCommand(int x, int y)
	{
		xBefore = x;
		yBefore = y;
	}
	public void execute()
	{
		map.placeTower(int xCoord, int yCoord);
	}
	public void undo()
	{
		map.takeTower(int xCoord, int yCoord);
	}
}