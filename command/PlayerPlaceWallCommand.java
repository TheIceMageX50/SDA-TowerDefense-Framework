package command;

import player.Player;

public class PlayerPlaceWallCommand implements Command
{
	private Player player;
	private int xCoord;
	private int yCoord;
	
	public PlayerPlaceWallCommand(Player player, int x, int y)
	{
		this.player = player;
		xCoord = x;
		yCoord = y;
	}
	
	public void execute()
	{
		player.placeWall(xCoord, yCoord);
	}
	
	public void undo()
	{
		player.takeWall(xCoord, yCoord);
	}
}