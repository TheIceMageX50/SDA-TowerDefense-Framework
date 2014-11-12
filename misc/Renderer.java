package misc;
import java.io.PrintStream;

import maps.GameMap;

public class Renderer
{
	private PrintStream screen;
	private GameMap map;

	public Renderer(PrintStream output, GameMap map)
	{
		screen = output;
		this.map = map;
	}

	public void renderMap()
	{
		int height = map.getHeight();
		int width = map.getWidth();
		screen.println("Successfully rendered the map (Type: " + map.getClass().getName()
				       + ") of dimensions " + width + "x" + height + ".");
	}
}
