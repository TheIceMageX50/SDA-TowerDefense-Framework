package command;

import misc.GameEngine;
import player.Player;

public class PlayerPlaceWallCommand implements Command
{
	private Player player;
	private int xCoord;
	private int yCoord;
	
	public PlayerPlaceWallCommand(Player player, int x, int y)
	{
		GameEngine engine = GameEngine.getInstance();
		engine.display("Player place wall command encapsulated as an object.");
		this.player = player;
		xCoord = x;
		yCoord = y;
	}
	
	public void execute()
	{
		GameEngine engine = GameEngine.getInstance();
		engine.display("Executing PlayerPlaceWallCommand...");
		player.placeWall(xCoord, yCoord);
	}
	
	public void undo()
	{
		GameEngine engine = GameEngine.getInstance();
		engine.display("Undoing PlayerPlaceWallCommand...");
		player.takeWall(xCoord, yCoord);
	}
}